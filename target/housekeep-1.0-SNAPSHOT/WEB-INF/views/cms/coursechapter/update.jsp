<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-
        <c:if test="${type==0}">直播课程</c:if>
        <c:if test="${type==1}">录播课程</c:if>
        <c:if test="${type==2}">面授课程</c:if></title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer }/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/select2/select2.css"/>
    <style>
        .control-label {
            padding-top: 4px !important;
        }
    </style>
</head>

<body class="no-skin">
<%@ include file="../../common/top.jsp" %>

<div class="main-container" id="main-container">
    <%@ include file="../../common/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">

            <div class="page-content">
                <!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${dynamicServer}/cms/coursechapter/update.do" method="post">

                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12">  修改课程信息 </span><!-- /.col -->
                                </h3>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>
                                <div class="col-sm-9">
                                    <input value="${lwCourseChapter.id}" name="id" type="hidden">
                                    <input value="${lwCourseChapter.roomId}" name="roomId" type="hidden">
                                    <select name="courseId" id="courseId" class="col-sm-12 col-lg-7" title="">

                                        <c:forEach var="course" items="${courses}" varStatus="">
                                            <option value="${course.id}"   ${lwCourseChapter.courseId==course.id?"selected":""}>${course.name}</option>
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程章节：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="title" name="title" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="${lwCourseChapter.title}">&nbsp;&nbsp;<label
                                        id="titleTip"></label>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-9">
                                    <input value="<fmt:formatDate value="${lwCourseChapter.startDate}" pattern="yyyy.MM.dd HH:mm"/>"
                                           name="startDate" class="Wdate   " style="height: 40px" type="text"
                                           onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">结束时间：</label>
                                <div class="col-sm-9">
                                    <input value="<fmt:formatDate value="${lwCourseChapter.endDate}" pattern="yyyy.MM.dd HH:mm"/>"
                                           name="endDate" class="Wdate  " style="height: 40px" type="text"
                                           onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">类型：</label>
                                <div class="col-sm-9">
                                    <select id="type" name="type"
                                            class="col-xs-12 col-sm-7 col-lg-7">
                                        <%--1:一对一课 2:班课--%>
                                        <option value="1"${lwCourseChapter.type==1?'selected':''} >一对一课</option>
                                        <option value="2" ${lwCourseChapter.type==2?'selected':''}>班课</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">url：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="url" name="url" value="${lwCourseChapter.url}"
                                           class="col-xs-12 col-sm-7 " title=""
                                    >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">时长：</label>

                                <div class="col-sm-9">
                                    <input type="text" id="timeLength" name="timeLength" maxlength="5" class="col-xs-10 col-sm-7"value="${lwCourseChapter.timeLength}"
                                           placeholder=""
                                           title="" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">房间最多人数：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="maxUsers" name="maxUsers" value="${lwCourseChapter.maxUsers}"
                                           class="col-xs-12 col-sm-7 " title=""
                                    >
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">可提前秒数(s)：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="preEnterTime" name="preEnterTime"
                                           class="col-xs-12 col-sm-7 " title=""
                                           value="${lwCourseChapter.preEnterTime}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">老师字节码：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="teacherCode" name="teacherCode" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           readonly
                                           title="" value="${lwCourseChapter.teacherCode}">&nbsp;&nbsp;
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">管理员字节码：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="adminCode" name="adminCode" maxlength="256"
                                           class="col-xs-12 col-sm-7" readonly
                                           placeholder=""
                                           title="" value="${lwCourseChapter.adminCode}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">排序：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="sort" name="sort" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="${lwCourseChapter.sort}">
                                </div>
                            </div>
                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 保存
                                    </button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button class="btn" type="button"
                                            onclick="backIndex()">
                                        <i class="ace-icon fa fa-undo bigger-110"></i> 取消
                                    </button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                <!-- /.main-content -->
            </div>
        </div>
    </div>
</div>

<!-- /.main-container -->
<%@ include file="../../common/js.jsp" %>
<script>
    window.UEDITOR_HOME_URL = '${staticServer}/assets/ueditor1.4.3/';
</script>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.config.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.all.min.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/lang/zh-cn/zh-cn.js"></script>
<script src="${staticServer }/assets/js/jquery.form.js"></script>
<script src="${staticServer }/assets/components/fuelux/js/spinbox.js"></script>
<script src="${staticServer }/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer }/assets/select2/select-topic-tags.js"></script>
<script src="${staticServer }/assets/select2/select2.full.js"></script>
<script src="${staticServer}/assets/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
    $(function () {
        $(".delChapter").on("click", function () {
            var id = $(this).attr("data-id");
            var $tr = $(this).closest("tr");
            bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该章节吗(彻底删除)？</a>", function (result) {
                if (result) {
                    $.ajax({
                        type: "GET",
                        url: "${dynamicServer}/cms/coursechapter/delete.do",
                        data: {
                            "id": id
                        },
                        contentType: 'application/json',
                        success: function () {
                            $tr.remove();
                        }
                    });
                }
            });
        });


        $("#infoForm").validate({
            errorElement: "label",
            errorClass: "valiError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                name: {
                    required: true,
                    maxlength: 20
                },
                startDate: {
                    required: true
                },
                endDate: {
                    required: true
                },
                sort: {
                    required: true,
                    maxlength: 20
                },
                title: {
                    required: true,
                    maxlength: 80
                },

            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    });
    function backIndex() {
        window.location.href = "${dynamicServer}/cms/coursechapter/index.do?chapterType=" + 0;
    };

</script>
</body>
</html>
