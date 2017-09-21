<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle}-章节管理</title>
    <%@ include file="../../common/header.jsp" %>
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
            <div class="breadcrumbs breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">首页</a></li>
                    <li class="active">章节管理</li>
                    <li class="active">章节管理</li>
                </ul>
            </div>

            <div class="page-content">

                <!-- /.page-header -->
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${dynamicServer}/cms/coursechapter/liveSave.do" method="post">
                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12">  添加课程章节信息 </span><!-- /.col -->
                                </h3>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>
                                <div class="col-sm-9">
                                    <select name="courseId" id="courseId" class="col-sm-12 col-lg-7" title="">

                                        <c:forEach var="course" items="${courses}" varStatus="">
                                            <option value="${course.id}">${course.name}</option>
                                        </c:forEach>
                                    </select>&nbsp;&nbsp;<label id="nameTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程章节：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="title" name="title" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="">&nbsp;&nbsp;<label
                                        id="titleTip"></label>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-9">
                                    <input id="startDate" name="startDate" class="Wdate col-xs-12 col-sm-7 " type="text"
                                           style="height: 40px"
                                           onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm',maxDate:'#F{$dp.$D(\'endDate\',{m:-15});}'})"/>&nbsp;&nbsp;<label
                                        id="startDateTip"> 结束时间与开始时间间隔需大于15分钟并小于24小时</label>


                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">结束时间：</label>
                                <div class="col-sm-9">
                                    <input id="endDate" name="endDate" class="Wdate col-xs-12 col-sm-7 " type="text"
                                           style="height: 40px"
                                           onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm',minDate:'#F{$dp.$D(\'startDate\',{m:15});}',maxDate:'#F{$dp.$D(\'startDate\',{H:15});}'})"/>&nbsp;&nbsp;<label
                                        id="endDateTip"></label>


                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">类型：</label>
                                <div class="col-sm-9">
                                    <select id="type" name="type"
                                            class="col-xs-12 col-sm-7 col-lg-7">
                                        <option value="1">一对一课</option>
                                        <option value="2" selected >班课</option>

                                    </select>&nbsp;&nbsp;<label
                                        id="typeTip"></label>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">播放类型：</label>
                                <div class="col-sm-9">
                                    <select id="mediaType" name="mediaType"
                                            class="col-xs-12 col-sm-7 col-lg-7">
                                        <option value="0">视频课</option>
                                        <option value="1">音频课</option>

                                    </select>&nbsp;&nbsp;<label
                                        id="mediaTypeTip"></label>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">房间最多人数：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="maxUsers" name="maxUsers"

                                           class="col-xs-12 col-sm-7 " title=""
                                           value="0">
                                </div>&nbsp;&nbsp;<label
                                    id="maxUsersTip"></label>

                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">可提前秒数(s)：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="preEnterTime" name="preEnterTime"

                                           class="col-xs-12 col-sm-7 " title=""
                                           value="3600">&nbsp;&nbsp;<label
                                        id="preEnterTimeTip"></label>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">排序：</label>
                                <div class="col-sm-9">
                                    <input type="number" id="sort" name="sort"

                                           class="col-xs-12 col-sm-7 " title=""
                                           value="0">&nbsp;&nbsp;<label
                                        id="sortTip"></label>
                                </div>
                            </div>

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 保存
                                    </button>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
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
<%@ include file="../../common/js.jsp" %>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>
<script src="${staticServer}/assets/js/jquery.form.js"></script>
<script src="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer}/assets/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
    $(function () {

        var date = dateFormatHour(new Date());

        $('#money').ace_spinner({
            min: 0.00,
            max: 99999.99,
            step: 0.50,
            fix: 2,
            precision: 2,
            interval: 100,
            icon_up: 'glyphicon glyphicon-plus',
            icon_down: 'glyphicon glyphicon-minus',
            btn_up_class: 'btn-success',
            btn_down_class: 'btn-danger',
            on_sides: true
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
        window.location.href = "${dynamicServer}/cms/coursechapter/index.do?chapterType=0";
    }

</script>
</body>
</html>
