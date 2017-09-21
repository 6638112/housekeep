<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<html lang="en">
<head>
    <title>${webTitle }-
        <c:if test="${type==0}">直播课程</c:if>
        <c:if test="${type==1}">录播课程</c:if>
        <c:if test="${type==2}">面授课程</c:if><c:if test="${type==3}">套餐课程</c:if></title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/select2/select2.css"/>
    <style>
        .control-label {
            padding-top: 4px !important;
        }

        .select2-container--default {
            width: 58% !important;
        }

        .select2-search--inline {
            width: 100% !important;
        }

        .select2-search__field {
            width: 100% !important;
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
                <div class="page-header">
                    <h1>
                        <c:if test="${type==0}">直播课程</c:if>
                        <c:if test="${type==1}">录播课程</c:if>
                        <c:if test="${type==2}">面授课程</c:if>
                        <c:if test="${type==3}">套餐课程</c:if>
                        <small><i class="ace-icon fa fa-angle-double-right"></i> 添加 <c:if test="${type==0}">直播课程</c:if>
                            <c:if test="${type==1}">录播课程</c:if>
                            <c:if test="${type==2}">面授课程</c:if>
                            <c:if test="${type==3}">套餐课程</c:if>
                        </small>
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${staticServer}/cms/course/save.do" method="post">
                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12"> 添加课程信息 </span><!-- /.col -->
                                </h3>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="name" name="name" maxlength="256" class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="">&nbsp;&nbsp;<label id="nameTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">营销人数：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="enrollment" name="enrollment" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="0">&nbsp;&nbsp;<label id="enrollmentTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">老师：</label>
                                <div class="col-sm-9">
                                    <select id="teacherIds" name="teacherIds"
                                            class="col-xs-12 col-sm-7 col-lg-7"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">科目：</label>
                                <div class="col-sm-9">
                                    <select id="subjectIds" name="subjectIds"
                                            class="col-xs-12 col-sm-7 col-lg-7"></select>
                                </div>
                            </div>
                            <c:if test="${type==3}">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">课程：</label>
                                    <div class="col-sm-9">
                                        <select id="lwCourseIds" name="lwCourseIds"
                                                class="col-xs-12 col-sm-7 col-lg-7"></select>
                                    </div>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">真实人数：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="realEnrollment" name="realEnrollment" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="0">&nbsp;&nbsp;<label id="realEnrollmentTip"></label>
                                </div>
                            </div>
                            <c:if test="${type==3}"><input name="courseType" type="hidden" value="1"></c:if>
                            <c:if test="${type!=3}"><input name="courseType" type="hidden" value="0"></c:if>

                            <input name="type" type="hidden" value="${type}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">最后观看时间：</label>
                                <div class="col-sm-9">
                                    <input id="viewEndDate" name="viewEndDate" class="Wdate col-xs-12 col-sm-7 "
                                           style="height: 40px" type="text"
                                           onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">停售时间：</label>
                                <div class="col-sm-9">
                                    <input id="noSaleDate" name="noSaleDate" class="Wdate col-xs-12 col-sm-7 "
                                           type="text" style="height: 40px"
                                           onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>


                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">开课时间：</label>
                                <div class="col-sm-9">
                                    <input id="startDate" name="startDate" class="Wdate col-xs-12 col-sm-7 " type="text"
                                           style="height: 40px" onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">结课时间：</label>
                                <div class="col-sm-9">
                                    <input id="endDate" name="endDate" class="Wdate col-xs-12 col-sm-7 " type="text"
                                           style="height: 40px" onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">seo名称：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="seoName" name="seoName" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="">&nbsp;&nbsp;<label id="seoNameTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">关键词：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="keyword" name="keyword" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="">&nbsp;&nbsp;<label id="keywordTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">seo描述：</label>
                                <div class="col-sm-9">
                                        <textarea id="remark" name="remark" class="col-xs-12 col-sm-7" rows="5"
                                                  placeholder="请输入seo描述..."
                                                  maxlength="500"></textarea>
                                    <label id="remarkTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课时：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="classHour" name="classHour" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="">&nbsp;&nbsp;<label id="classHourTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程金额：</label>
                                <div class="col-sm-9">
                                    <input id="courseAmount" type="text" name="courseAmount"
                                           class="col-xs-10 col-sm-4" placeholder="排序"
                                           value="0">
                                    <label id="courseAmountTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label ">课程封面:</label>
                                <div class="col-sm-9 control-div">
                                    <ul id="imageUl" class="ace-thumbnails clearfix hidden"
                                        style=" display: inline-block;">
                                        <li>
                                            <a data-rel="colorbox">
                                                <img width="150" id="icon-img" alt="150x150" data-path="" src=""/>
                                                <div class="tools tools-top">
                                                    <a class="delPic"> <i class="ace-icon fa fa-times red">删除</i>
                                                    </a></div>
                                            </a>
                                        </li>
                                    </ul>
                                    <input type="hidden" id="icon_hidden" name="icon" value="">
                                    <a href="#icon-modal" class="btn btn-white btn-primary" data-toggle="modal"
                                       style="position: absolute;top: 2px;">
                                        <i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择图片
                                    </a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label ">分享图片:</label>
                                <div class="col-sm-9 control-div">
                                    <ul id="shareUrlUl" class="ace-thumbnails clearfix hidden"
                                        style=" display: inline-block;">
                                        <li>
                                            <a data-rel="colorbox">
                                                <img width="150" id="shareUrl-img" alt="150x150" data-path="" src=""/>
                                                <div class="tools tools-top">
                                                    <a class="delPic"> <i class="ace-icon fa fa-times red">删除</i>
                                                    </a></div>
                                            </a>
                                        </li>
                                    </ul>
                                    <input type="hidden" id="shareUrl_hidden" name="shareUrl" value="">
                                    <a href="#shareUrl-modal" class="btn btn-white btn-primary" data-toggle="modal"
                                       style="position: absolute;top: 2px;">
                                        <i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择图片
                                    </a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否邮寄：</label>
                                <div class="col-sm-9">
                                    <div class="radio">
                                        <label>
                                            <input name="isSend" type="radio" class="ace" value="1">
                                            <span class="lbl">是</span>
                                        </label>
                                        <label>
                                            <input name="isSend" type="radio" class="ace" value="0" checked>
                                            <span class="lbl">否</span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">邮寄资料：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="sendData" name="sendData" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="">&nbsp;&nbsp;<label id="sendDataTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">排序：</label>
                                <div class="col-sm-9">
                                    <input type="number" id="sort" name="sort" maxlength="256"
                                           class="col-xs-12 col-sm-7"
                                           placeholder=""
                                           title="" value="0">&nbsp;&nbsp;<label id="sortTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">图片文件：</label>
                                <div class="col-sm-9">
                                    <div class="col-xs-12 col-sm-7" style="padding: 0">
                                        <script id="content" name="content"
                                                type="text/plain"></script>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${type==2}">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">优惠政策：</label>
                                    <div class="col-sm-9">
                                        <div class="col-xs-12 col-sm-7" style="padding: 0">
                                            <script id="favourable" name="favourable"
                                                    type="text/plain"></script>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${type!=3}">
                                <div class="form-group ">
                                    <h3 class="row header smaller lighter blue">
                                        <span class="col-xs-6"> 添加章节信息 </span><!-- /.col -->
                                        <button type="button" class="btn btn-success btn-sm" onclick="addChapter()"
                                                style="float: right; margin-right: 28px;" id="btn-search">
                                            <i class="ace-icon fa fa-plus"></i> 添加章节
                                        </button>
                                    </h3>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <table id="chapterTable"
                                                   class="table table-striped table-bordered table-hover">
                                                <thead>
                                                <tr>
                                                    <th style="text-align: center;">章节名称</th>
                                                    <th style="text-align: center;">排序</th>
                                                    <th style="text-align: center;">视频时长</th>
                                                    <c:if test="${type==0}">
                                                        <th style="text-align: center;">URL</th>
                                                        <th style="text-align: center;">类型</th>
                                                        <th style="text-align: center;">播放方式</th>
                                                        <th style="text-align: center;">房间最大数</th>
                                                        <th style="text-align: center;">开始时间</th>
                                                        <th style="text-align: center;">结束时间</th>
                                                    </c:if>
                                                    <c:if test="${type==1}">
                                                        <th style="text-align: center;">URL</th>
                                                    </c:if>
                                                    <c:if test="${type==2}">
                                                        <th style="text-align: center;">开始时间</th>
                                                        <th style="text-align: center;">结束时间</th>
                                                    </c:if>
                                                    <th style="text-align: center;width: 85px">操作</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.span -->
                                    </div>
                                </div>
                            </c:if>
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


<div id="icon-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    上传封面图片
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <c:url value="${uploadServer}/common/upload.do" var="upload_url"/>
                            <form:form action="${upload_url}"
                                       enctype="multipart/form-data" method="post" id="icon-form">
                                <input type="hidden" name="file_type" value="lwCourse">
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input name="file" type="file" id="icon-input"
                                               accept="image/png,image/jpeg,image/gif,image/bmp"/>
                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="submit">
                                            <i class="ace-icon fa fa-cloud-upload bigger-110"></i> 上传
                                        </button>
                                        <button class="btn btn-white btn-primary" type="button" id="closeicon-modal"
                                                data-dismiss="modal">
                                            <i class="ace-icon fa fa-undo bigger-110"></i> 取消
                                        </button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer no-margin-top"></div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<div id="shareUrl-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    上传分享图片
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <c:url value="${uploadServer}/common/upload.do" var="upload_url"/>
                            <form:form action="${upload_url}"
                                       enctype="multipart/form-data" method="post" id="shareUrl-form">
                                <input type="hidden" name="file_type" value="shareUrl">
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input name="file" type="file" id="shareUrl-input"
                                               accept="image/png,image/jpeg,image/gif,image/bmp"/>
                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="submit">
                                            <i class="ace-icon fa fa-cloud-upload bigger-110"></i> 上传
                                        </button>
                                        <button class="btn btn-white btn-primary" type="button" id="closeShareUrl-modal"
                                                data-dismiss="modal">
                                            <i class="ace-icon fa fa-undo bigger-110"></i> 取消
                                        </button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer no-margin-top"></div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
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
<script src="${staticServer}/assets/js/jquery.form.js"></script>
<script src="${staticServer}/assets/components/fuelux/js/spinbox.js"></script>
<script src="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer}/assets/select2/select-topic-tags.js"></script>
<script src="${staticServer}/assets/select2/select2.full.js"></script>
<script src="${staticServer}/assets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $(function () {

        $('#teacherIds').select2({
            tags: true,
            multiple: true,
            createTag: function (params) {
                console.log(arguments);
                return null;
            },
            placeholder: '请输入要关联的老师名称',
            language: {
                noResults: function () {
                    return '没有找到该老师';
                },
                inputTooShort: function () {
                    return '请至少输入1个字符';
                }
            },
            ajax: {
                url: "${staticServer}/cms/teacher/getListByNickName.do",
                type: "get",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        nickName: params.term,
                        page: params.page
                    };
                },
                processResults: function (data, params) {
                    params.page = params.page || 1;

                    return {
                        results: data
                    };
                },
                cache: true
            },
            escapeMarkup: function (markup) {
                return markup;
            },
            minimumInputLength: 1,
            templateResult: function (teacher) {
                return teacher.nickName;
            },
            templateSelection: function (teacher) {
                return teacher.nickName;
            }
        });
        $('#subjectIds').select2({
            tags: true,
            multiple: true,
            createTag: function (params) {
                console.log(arguments);
                return null;
            },
            placeholder: '请输入要关联的科目',
            language: {
                noResults: function () {
                    return '没有找到该科目';
                },
                inputTooShort: function () {
                    return '请至少输入1个字符';
                }
            },
            ajax: {
                url: "${staticServer}/cms/subject/getListBySubject.do",
                type: "get",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        subject: params.term,
                        page: params.page
                    };
                },
                processResults: function (data, params) {
                    params.page = params.page || 1;

                    return {
                        results: data
                    };
                },
                cache: true
            },
            escapeMarkup: function (markup) {
                return markup;
            },
            minimumInputLength: 1,
            templateResult: function (subject) {
                return subject.subject;
            },
            templateSelection: function (subject) {
                return subject.subject;
            }
        });
        $('#lwCourseIds').select2({
            tags: true,
            multiple: true,
            createTag: function (params) {
                console.log(arguments);
                return null;
            },
            placeholder: '请输入要关联的课程',
            language: {
                noResults: function () {
                    return '没有找到该课程';
                },
                inputTooShort: function () {
                    return '请至少输入1个字符';
                }
            },
            ajax: {
                url: "${staticServer}/cms/course/getListByName.do",
                type: "get",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        name: params.term,
                        page: params.page
                    };
                },
                processResults: function (data, params) {
                    params.page = params.page || 1;

                    return {
                        results: data
                    };
                },
                cache: true
            },
            escapeMarkup: function (markup) {
                return markup;
            },
            minimumInputLength: 1,
            templateResult: function (course) {
                return course.name;
            },
            templateSelection: function (course) {
                return course.name;
            }
        });

        $.fn.datetimepicker.dates['zh'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
            meridiem: ["上午", "下午"],
            today: "今天"
        };


        $('#chapterList0StartDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#chapterList0EndDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#courseAmount').ace_spinner({
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
        UE.getEditor('content', {
            toolbars: [
                ['fullscreen', 'source', 'undo', 'redo'],
                ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript',
                    'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain',
                    '|', 'forecolor', 'backcolor', 'selectall',
                    'insertimage', 'cleardoc']
            ],
            initialFrameHeight: 300,
            imagePath: '${pageContext.request.contextPath}/upload'
        });

        UE.getEditor('favourable', {
            toolbars: [
                ['fullscreen', 'source', 'undo', 'redo'],
                ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript',
                    'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain',
                    '|', 'forecolor', 'backcolor', 'selectall',
                    'insertimage', 'cleardoc']
            ],
            initialFrameHeight: 300,
            imagePath: '${pageContext.request.contextPath}/upload'
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
                categoryId: {
                    required: true
                }
            },
            submitHandler: function (form) {
                form.submit();
            }
        });

        //操作背景图片
        $('#icon-input').ace_file_input({
            style: 'well',
            btn_choose: '点击选择',
            btn_change: null,
            no_icon: 'ace-icon fa fa-picture-o',
            droppable: false,
            allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
            allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
            thumbnail: 'large',
            maxSize: 1024000,
            before_remove: function () {
                return true;
            }
        }).on('change', function () {
            var $icon_input = $('#icon-input');
            if ($icon_input.val() == '') {
                $icon_input.ace_file_input('reset_input');
            }
        }).on('file.error.ace', function (ev, info) {
            if (info.error_count['ext'] || info.error_count['mime'])
                $.notify({message: "请选择图片!", z_index: 1051});
            if (info.error_count['size'])
                $.notify({message: "图片大小不超过1M!!", z_index: 1051});
        });
        var $icon_form = $("#icon-form");
        $icon_form.on('submit', function () {
            var imgcheck = $("#icon-input").val();
            if (imgcheck === '') {
                return false;
            }
            $icon_form.ajaxSubmit({
                type: 'post', // 提交方式 get/post
                url: $icon_form.attr('action'),
                dataType: 'json',
                success: function (result) {
                    if (result && result.success) {
                        var img_path = result.createFilePath;
                        $("#closeicon-modal").click();
                        $("[name=icon]").val(img_path);
                        var img_url = '${imageServer}' + img_path;

                        var $icon_img = $("#icon-img");
                        if ($icon_img.attr("src") != '') {
                            $.ajax({
                                url: '${uploadServer}/common/delFile',
                                data: {
                                    path: $icon_img.attr("data-path")
                                },
                                type: 'post',
                                success: function (result) {
                                    if (result.success) {
                                        $icon_img.attr("src", img_url);
                                        $icon_img.attr("data-path", img_path);
                                        $("#imageUl").removeClass("hidden");
                                    } else {
                                        $.notify({message: "文件路径错误!", z_index: 15111});
                                    }
                                }
                            })
                        } else {
                            $icon_img.attr("src", img_url);
                            $icon_img.attr("data-path", img_path);
                            $("#imageUl").removeClass("hidden");
                            $('#iconTip').html('');
                        }
                        return;
                    }

                    alert((result && result.message) || '上传失败');
                }
            });
            return false;
        });
        $("#imageUl").on('click', '.delPic', function () {
            var that = $(this);
            var path = that.closest("li").find("img").attr("data-path");
            $.ajax({
                url: '${uploadServer}/common/delFile.do',
                data: {
                    path: path
                },
                type: 'GET',
                success: function (result) {
                    if (result.success) {
                        $("#iconTip").html('');
                        $("#imageUl").addClass("hidden");
                        $("[name=icon]").val('');
                        $("#icon-img").attr("src", "");
                    } else {
                        $.notify({message: "文件路径错误!", z_index: 15111});
                    }
                }
            })
        });

        //操作分享图片
        $('#shareUrl-input').ace_file_input({
            style: 'well',
            btn_choose: '点击选择',
            btn_change: null,
            no_icon: 'ace-icon fa fa-picture-o',
            droppable: false,
            allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
            allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
            thumbnail: 'large',
            maxSize: 1024000,
            before_remove: function () {
                return true;
            }
        }).on('change', function () {
            var $shareUrl_input = $('#shareUrl-input');
            if ($shareUrl_input.val() == '') {
                $shareUrl_input.ace_file_input('reset_input');
            }
        }).on('file.error.ace', function (ev, info) {
            if (info.error_count['ext'] || info.error_count['mime'])
                $.notify({message: "请选择图片!", z_index: 1051});
            if (info.error_count['size'])
                $.notify({message: "图片大小不超过1M!!", z_index: 1051});
        });
        var $shareUrl_form = $("#shareUrl-form");
        $shareUrl_form.on('submit', function () {
            var shareUrlcheck = $("#shareUrl-input").val();
            if (shareUrlcheck === '') {
                return false;
            }
            $shareUrl_form.ajaxSubmit({
                type: 'post', // 提交方式 get/post
                url: $shareUrl_form.attr('action'),
                dataType: 'json',
                success: function (result) {
                    if (result && result.success) {
                        var img_path = result.createFilePath;
                        $("#closeShareUrl-modal").click();
                        $("[name=shareUrl]").val(img_path);
                        var img_url = '${imageServer}' + img_path;

                        var $shareUrl_img = $("#shareUrl-img");
                        if ($shareUrl_img.attr("src") != '') {
                            $.ajax({
                                url: '${uploadServer}/common/delFile',
                                data: {
                                    path: $shareUrl_img.attr("data-path")
                                },
                                type: 'post',
                                success: function (result) {
                                    if (result.success) {
                                        $shareUrl_img.attr("src", img_url);
                                        $shareUrl_img.attr("data-path", img_path);
                                        $("#shareUrlUl").removeClass("hidden");
                                    } else {
                                        $.notify({message: "文件路径错误!", z_index: 15111});
                                    }
                                }
                            })
                        } else {
                            $shareUrl_img.attr("src", img_url);
                            $shareUrl_img.attr("data-path", img_path);
                            $("#shareUrlUl").removeClass("hidden");
                        }
                        return;
                    }

                    alert((result && result.message) || '上传失败');
                }
            });
            return false;
        });
        $("#shareUrlUl").on('click', '.delPic', function () {
            var that = $(this);
            var path = that.closest("li").find("img").attr("data-path");
            $.ajax({
                url: '${uploadServer}/common/delFile.do',
                data: {
                    path: path
                },
                type: 'GET',
                success: function (result) {
                    if (result.success) {
                        $("#shareUrlUl").addClass("hidden");
                        $("[name=shareUrl]").val('');
                        $("#shareUrl-img").attr("src", "");
                    } else {
                        $.notify({message: "文件路径错误!", z_index: 15111});
                    }
                }
            })
        });
    });

    function backIndex() {
        window.location.href = "${staticServer}/cms/course/index.do?type=" +${type};
    }

    function addChapter() {
        var index = $("#chapterTable").find("tr:last").attr("data-index");
        if (index == null || index == undefined || index == "") {
            index = 0;
        } else {
            index = Number(index) + Number(1);
        }
        var vHTML = '  <tr data-index="' + index + '" id="chapter' + index + '">\
            <td><input type="text" name="chapterList[' + index + '].title" class="col-xs-12" title=""\
        value=""/></td>\
          <td><input type="text" name="chapterList[' + index + '].sort" class="col-xs-12" title=""\
        value="0"/></td>\
        <td><input type="text" name="chapterList[' + index + '].timeLength" class="col-xs-12" title=""\
        value=""/></td>';
        if (${type==0}) {
            vHTML += '<td><input type="text" name="chapterList[' + index + '].url" class="col-xs-12" title=""\
        value=""/></td>\
            <td>\
            <div class="radio">\
            <label>\
            <input name="chapterList[' + index + '].type" type="radio" class="ace" value="1"\>\
        <span class="lbl">一对一课</span>\
            </label>\
            <label>\
            <input name="chapterList[' + index + '].type" type="radio" class="ace" value="2" checked >\
            <span class="lbl">班课</span>\
            </label>\
            </div>\
            </td>\
            <td>\
            <div class="radio">\
            <label>\
            <input name="chapterList[' + index + '].mediaType" type="radio" class="ace" value="0"\
        checked >\
        <span class="lbl">视频课</span>\
            </label>\
            <label>\
            <input name="chapterList[' + index + '].mediaType" type="radio" class="ace" value="1">\
            <span class="lbl">音频课</span>\
            </label>\
            </div>\
            </td>\
            <td>\
            <input type="text" name="chapterList[' + index + '].maxUsers" class="col-xs-12" title=""\
        value="0"/>\
            </td>\
             <td>\
       <input id="chapterList' + index + 'startDate" name="chapterList[' + index + '].startDate"  class="Wdate col-xs-12  "\
        type="text" style="height: 40px ;width: 120px"  onclick="WdatePicker({dateFmt:\'yyyy.MM.dd HH:mm:ss\',maxDate:\'#F{$dp.$D(\\\'chapterList' + index + 'endDate\\\',{m:-15});}\'})"/>\
            </td>\
            <td>\
               <input id="chapterList' + index + 'EndDate" name="chapterList[' + index + '].endDate"  class="Wdate col-xs-12 " type="text" style="height: 40px ;width: 120px" ' +
                ' onclick="WdatePicker({dateFmt:\'yyyy.MM.dd HH:mm:ss\',minDate:\'#F{$dp.$D(\\\'chapterList' + index + 'startDate\\\',{m:15});}\',' +
                'maxDate:\'#F{$dp.$D(\\\'chapterList' + index + 'startDate\\\',{H:15});}\'})"/>\
 </td>';
//            <input type="text"  name="chapterList[' + index + '].endDate"  \
//                onfocus="WdatePicker({dateFmt:&quot;yyyy.MM.dd&nbsp;HH:mm:ss&quot;)" id="chapterList' + index + 'EndDate" class="input-text Wdate" style="width:120px;">\

        }
        if (${type==1}) {
            vHTML += '<td><input type="text" name="chapterList[' + index + '].url" class="col-xs-12" title=""\
        value=""/></td>';
        }
        if (${type==2}) {
            vHTML += '<td>\
           <input id="chapterList' + index + 'startDate" name="chapterList[' + index + '].startDate"  class="Wdate col-xs-12  "\
        type="text" style="height: 40px " onclick="WdatePicker({dateFmt:\'yyyy.MM.dd HH:mm\'})"/>\
            </td>\
            <td>\
               <input id="chapterList' + index + 'EndDate" name="chapterList[' + index + '].endDate"  class="Wdate  col-xs-12" type="text" style="height: 40px " onclick="WdatePicker({dateFmt:\'yyyy.MM.dd HH:mm\'})"/>\
 </td>';
        }
        vHTML += '<td>\
    <a class="btn btn-sm btn-danger" onclick="delVhtml(' + index + ')">\
            <i class="ace-icon fa fa-pencil-square-o "></i>删除</a>\
            </td>\
            </tr>';
        $("#chapterTable").find("tbody").append(vHTML);

        $('#chapterList' + index + 'StartDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });

    }

    function delVhtml(index) {
        var $tr = $("#chapterTable").find("tbody").find("tr");
        console.log($($($($tr).get(index)).find("input:first")).val());
        $("#chapter" + index).remove();
    }

</script>
</body>
</html>
