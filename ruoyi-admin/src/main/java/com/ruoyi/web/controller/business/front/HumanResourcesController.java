package com.ruoyi.web.controller.business.front;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.view.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(value = "humanResourcesController", tags = "人资数据面板接口控制器")
@RestController
@RequestMapping("/hr/panel_data")
public class HumanResourcesController {
    /**
     * 人资server注入
     */
    private static ISysUserService userService;

    /**
     * 部门server注入
     */
    @Autowired
    private ISysDeptService deptService;

    public HumanResourcesController(ISysUserService userService) {
        this.userService = userService;
    }

    /**
     * 获取人资近三年的数据列表
     */
    @GetMapping("/getHrByYearTime/{departmentId}/{time}")
    @ApiOperation(value = "4.2.2本部人资管理-人资近三年的数据统计")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = HRListView.class)
    })
    public AjaxResult getHrByYearTime(@PathVariable("departmentId") @ApiParam(value = "部门id", required = true) String departmentId,
                                      @PathVariable("time") @ApiParam(value = "年份例如：2020 则返回2020年之前入职数据", required = true) String time) {
        SysUser user = new SysUser();
        if (StringUtils.isEmpty(time)) return AjaxResult.error("年份不能为空");
        if (StringUtils.isEmpty(departmentId)) return AjaxResult.error("部门id不能为空");
        user.setYear(time);
        user.setDeptId(Long.parseLong(departmentId));
        // 然后对象
        Map<String, Object> _result = new HashMap();
        // 每一个部门的对象
        List<Map> data = new ArrayList();
        //1.查到所有的部门
        SysDept sysDept = new SysDept();
        sysDept.setParentId(Long.parseLong(departmentId));
        List<SysDept> sysDepts = deptService.selectDeptList(sysDept);
        //2.合计
        Long totalNumber = 0L;
        //3.每一个部门
        for (SysDept item : sysDepts) {
            SysUser user2 = new SysUser();
            user2.setYear(time);
            user2.setDeptId(item.getDeptId());
            /// 当前年
//            user.setDeptId(item.getDeptId());
            List<SysUser> list1 = userService.selectUserList(user2);
            totalNumber += list1.size();
            /// 前一年
            Long previousYear = Long.parseLong(time) - 1;
            user2.setYear(previousYear + "");
            List<SysUser> list2 = userService.selectUserList(user2);
            /// 大前年
            Long yearBefore = Long.parseLong(time) - 2;
            user2.setYear(yearBefore + "");
            List<SysUser> list3 = userService.selectUserList(user2);
            if (list1 != null) {
                //为了保持顺序 采用链表
                Map<String, Object> stringListHashMap = new LinkedHashMap<>();
                stringListHashMap.put("deptName", item.getDeptName());
                stringListHashMap.put(time, list1.size() + "");
                stringListHashMap.put(previousYear + "", list2.size() + "");
                stringListHashMap.put(yearBefore + "", list3.size() + "");
                data.add(stringListHashMap);
            }

        }
        _result.put("totalNumber", totalNumber + "");
        _result.put("data", data);
        return AjaxResult.success(_result);
    }

    /**
     * 获取性别统计
     *
     * @return
     */
    @GetMapping("/getGenderNumber/{departmentId}/{time}")
    @ApiOperation(value = "4.2.2本部人资管理-性别比例")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = HRMenWomenProportion.class)
    })
    public AjaxResult getGenderNumber(@PathVariable("departmentId") @ApiParam(value = "部门id", required = true) Long departmentId,
                                      @PathVariable("time") @ApiParam(value = "年份例如：2020 则返回2020年之前入职数据", required = true) Long time) {
        Map _result = new HashMap();
        List<SysUser> boys = new ArrayList<>();
        List<SysUser> girls = new ArrayList<>();
        SysUser user = new SysUser();
        user.setDeptId(departmentId);
        List<SysUser> _list = userService.selectUserList(user);
        if (_list != null) {
            for (SysUser item : _list) {
                if ("0".equals(item.getSex().trim())) {
                    // 男
                    boys.add(item);
                } else if ("1".equals(item.getSex().trim())) {
                    // 女
                    girls.add(item);
                }
            }
        }
        HashMap<Object, Object> bItem = new HashMap<>();
        HashMap<Object, Object> gItem = new HashMap<>();
        // 男生
        bItem.put("number", boys.size() + "");
        // 男生百分比
        double boyAbsolutely = (boys.size() / Double.parseDouble(boys.size() + girls.size() + ""));
        bItem.put("absolutely", boyAbsolutely * 100 + "");
        _result.put("boy", bItem);
        // 女生
        gItem.put("number", girls.size() + "");
        gItem.put("absolutely", (1 - boyAbsolutely) * 100 + "");
        _result.put("girl", gItem);
        return AjaxResult.success(_result);
    }

    /**
     * 学历统计
     *
     * @return
     */
    @GetMapping("/getDegreeStatistics/{departmentId}")
    @ApiOperation(value = "4.2.2本部人资管理-学历统计")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = HRXLView.class),
    })
    public AjaxResult getDegreeStatistics(@PathVariable("departmentId") @ApiParam(value = "部门id", required = true) Long departmentId) {
        Map _rs = new HashMap();
        // 研究生
        List<SysUser> graduateStudents = new ArrayList<>();
        // 本科
        List<SysUser> undergraduateCourses = new ArrayList<>();
        // 专科
        List<SysUser> specializedSubjects = new ArrayList<>();
        // 中专及以下学历
        List<SysUser> others = new ArrayList<>();
        SysUser user = new SysUser();
        if (departmentId != null) user.setDeptId(departmentId);
        List<SysUser> _list = userService.selectUserList(user);
        if (_list != null) {
            for (SysUser item : _list) {
                String xlStr = item.getEducationBackground();
                if (xlStr == null) xlStr = "";
                if ("0".equals(xlStr.trim())) {
                    // 研究生及以上
                    graduateStudents.add(item);
                } else if ("1".equals(xlStr.trim())) {
                    // 本科学历
                    undergraduateCourses.add(item);
                } else if ("2".equals(xlStr.trim())) {
                    // 专科学历
                    specializedSubjects.add(item);
                } else if ("3".equals(xlStr.trim())) {
                    // 中专及以下学历
                    others.add(item);
                }
            }
        }
        //总数量
        double total = Double.parseDouble(others.size() + specializedSubjects.size() + graduateStudents.size() + undergraduateCourses.size() + "");
        // 研究生
        HashMap graduateStudentsItem = new HashMap<>();
        // 研究生及以上
        graduateStudentsItem.put("number", graduateStudents.size() + "");
        // 研究生及以上百分比
        double gsAbsolutely = (graduateStudents.size() / total);
        graduateStudentsItem.put("absolutely", gsAbsolutely * 100 + "");
        _rs.put("graduateStudents", graduateStudentsItem);

        // 本科
        HashMap undergraduateCoursesItem = new HashMap<>();
        // 本科
        undergraduateCoursesItem.put("number", undergraduateCourses.size() + "");
        // 本科百分比
        double ucAbsolutely = (undergraduateCourses.size() / total);
        undergraduateCoursesItem.put("absolutely", ucAbsolutely * 100 + "");
        _rs.put("undergraduateCourses", undergraduateCoursesItem);

        // 专科
        HashMap<Object, Object> specializedSubjectsItem = new HashMap<>();
        specializedSubjectsItem.put("number", specializedSubjects.size() + "");
        double ssAbsolutely = (specializedSubjects.size() / total);
        specializedSubjectsItem.put("absolutely", ssAbsolutely * 100 + "");
        _rs.put("specializedSubjects", specializedSubjectsItem);

        // 其他
        HashMap<Object, Object> othersItem = new HashMap<>();
        othersItem.put("number", others.size() + "");
        othersItem.put("absolutely", (1 - ssAbsolutely - ucAbsolutely - gsAbsolutely) * 100 + "");
        _rs.put("others", othersItem);
        return AjaxResult.success(_rs);
    }

    /**
     * 高级职称 0  中级职称 1  初级职称 2
     *
     * @return
     */
    @GetMapping("/getTitleStatistical/{departmentId}/{time}")
    @ApiOperation(value = "4.2.2本部人资管理-职称统计")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = HRWorkerType.class),
    })
    public AjaxResult getTitleStatistical(@PathVariable("departmentId") @ApiParam(value = "部门id", required = true) Long departmentId, @PathVariable("time") @ApiParam(value = "年份例如：2020 则返回2020年之前入职数据", required = true) String time) {
        List<Map> _rs = new LinkedList<>();
        SysUser user = new SysUser();
        if (time == null || time.isEmpty()) {
            return AjaxResult.error("年份不能为空");
        }
        user.setYear(time);
        if (departmentId == null) {
            return AjaxResult.error("部门id不能为空");
        }
        user.setDeptId(departmentId);
        // 当前年
        _rs.add(buildTitleStatistical(user, time));
        Long previousYear = Long.parseLong(time) - 1;
        // 前一年
        user.setYear(previousYear + "");
        _rs.add(buildTitleStatistical(user, previousYear + ""));
        /// 大前年
        Long yearBefore = Long.parseLong(time) - 2;
        user.setYear(yearBefore + "");
        _rs.add(buildTitleStatistical(user, yearBefore + ""));
        return AjaxResult.success(_rs);
    }

    private Map<String, Object> buildTitleStatistical(SysUser user, String time) {
        Map<String, Object> _rs = new HashMap();
        // 高级
        List<SysUser> senior = new ArrayList<>();
        // 中级
        List<SysUser> intermediate = new ArrayList<>();
        // 初级
        List<SysUser> primary = new ArrayList<>();
        List<SysUser> _list = userService.selectUserList(user);
        if (_list != null) {
            for (SysUser item : _list) {
                String xlStr = item.getEducationBackground();
                if (xlStr == null) xlStr = "";
                if ("0".equals(xlStr.trim())) {
                    // 高级
                    senior.add(item);
                } else if ("1".equals(xlStr.trim())) {
                    // 中级
                    intermediate.add(item);
                } else if ("2".equals(xlStr.trim())) {
                    // 初级
                    primary.add(item);
                }
            }
        }
        List<Integer> _rl = new ArrayList<>();
        _rl.add(primary.size());
        _rl.add(intermediate.size());
        _rl.add(senior.size());
        _rs.put("name", time + "年");
        _rs.put("type", "bar");
        _rs.put("barWidth", 12);
        _rs.put("data", _rl);
        return _rs;
    }

    @GetMapping("/getAgeStatistics/{departmentId}/{time}")
    @ApiOperation(value = "4.2.2本部人资管理-年龄统计")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = HRAgeStatisticsView.class),
    })
    public AjaxResult getAgeStatistics(@PathVariable("departmentId") @ApiParam(value = "部门id", required = true) String departmentId, @PathVariable("time") @ApiParam(value = "年份例如：2020 则返回2020年之前入职数据", required = true) String time) {
        SysUser user = new SysUser();
        if (time == null || time.isEmpty()) {
            return AjaxResult.error("年份不能为空");
        }
        if (departmentId == null || time.isEmpty()) {
            return AjaxResult.error("部门id不能为空");
        }
        Map _result = new LinkedHashMap();
        try {
            user.setDeptId(Long.parseLong(departmentId));
            // 当前年
            user.setYear(time);
            List<Integer> currentYearData1 = getCurrentYearData(user);
            // 前一年
            user.setYear(Long.parseLong(time) - 1 + "");
            List<Integer> currentYearData2 = getCurrentYearData(user);
            // 后一年
            user.setYear(Long.parseLong(time) - 2 + "");
            List<Integer> currentYearData3 = getCurrentYearData(user);
            _result.put("currentYearData1", currentYearData1);
            _result.put("currentYearData2", currentYearData2);
            _result.put("currentYearData3", currentYearData3);
        } catch (Exception e) {
            AjaxResult.error("查询异常");
        }
        return AjaxResult.success(_result);
    }

    /**
     * 返回当年的 年龄列表
     *
     * @return
     */
    public static List<Integer> getCurrentYearData(SysUser user) {
        List<Integer> _result = new LinkedList<>();

        List<SysUser> _list = userService.selectUserList(user);
        // 小于30岁
        List<SysUser> lt30 = new ArrayList<>();
        // 31-40
        List<SysUser> lt40 = new ArrayList<>();
        // 41-50
        List<SysUser> lt50 = new ArrayList<>();
        // 51-54
        List<SysUser> lt54 = new ArrayList<>();
        // >54
        List<SysUser> gt54 = new ArrayList<>();
        for (SysUser item : _list) {
            Date birthday = item.getBirthday();
            if (birthday != null) {
                if (getAge(birthday) <= 30) {
                    // 小于等于30
                    lt30.add(item);
                } else if (getAge(birthday) <= 40) {
                    // 小于等于40
                    lt40.add(item);
                } else if (getAge(birthday) <= 50) {
                    // 小于等于50
                    lt50.add(item);
                } else if (getAge(birthday) <= 54) {
                    // 小于等于54
                    lt54.add(item);
                } else {
                    gt54.add(item);
                    // 大于等于55
                }
            }
        }
        _result.add(lt30.size());
        _result.add(lt40.size());
        _result.add(lt50.size());
        _result.add(lt54.size());
        _result.add(gt54.size());
        return _result;

    }

    /**
     * 根据出生年月计算年龄
     *
     * @param
     * @return返回年龄
     */
    //由出生日期获得年龄
    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            } else {
                age--;
            }
        }
        return age;
    }

    public static Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }
}


