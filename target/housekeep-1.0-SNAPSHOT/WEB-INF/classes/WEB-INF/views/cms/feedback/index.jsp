<%--
  Created by IntelliJ IDEA.
  User: 1553280431@qq.com
  Date: 2017/5/25
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="../../common/taglib.jsp" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-用户反馈</title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/select2/select2.css"/>
</head>

<body class="no-skin">
<%@ include file="../../common/top.jsp" %>
<div class="main-container" id="main-container">
    <%@ include file="../../common/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <!-- #section:basics/content.breadcrumbs -->
            <div class="breadcrumbs  breadcrumbs-fixed" id="breadcrumbs">
            </div>
            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box" id="widget-box-search">
                            <div class="widget-header">
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <form:form action="/" method="post"
                                               cssClass="form-horizontal"
                                               cssStyle="padding-top: 10px;">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">用户姓名：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="userNumSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">手机号：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="phoneSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <button type="button" class="btn btn-primary btn-sm"
                                                            id="btn-search">
                                                        <i class="ace-icon fa fa-search"></i> 查询
                                                    </button>
                                                    &nbsp;&nbsp;
                                                    <a type="button" class="btn btn-success btn-sm"
                                                       href="#modal-edit" data-toggle="modal"
                                                       data-backdrop="static" onclick="flushForm()"
                                                       id="btn-add">
                                                        <i class="ace-icon fa fa-search"></i> 新增

                                                    </a>
                                                        <%--<a href="#modal-import" class="btn btn-warning btn-sm"
                                                           data-toggle="modal">
                                                            <i class="ace-icon fa fa-file-excel-o"></i>导入</a>--%>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <div class="hr hr-18 dotted hr-double"></div>
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="lwInvitation" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="background-color: #E5E5E5">邀请人数</th>
                                        <th style="background-color: #E5E5E5">课程名称</th>
                                        <th style="background-color: #E5E5E5">课程类型</th>

                                        <th style="background-color: #E5E5E5">状态</th>
                                        <th style="background-color: #E5E5E5">操作</th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>
                            <!-- /.span -->
                        </div>
                    </div>
                    <!-- /.span -->
                </div>
            </div>
            <!-- /.main-content -->
        </div>
        <!-- /.main-container -->
    </div>
</div>
<div id="modal-edit" class="modal fade" role="dialog" aria-hidden="true" style="overflow-y: auto !important;">
    <div class="modal-dialog" style="width: 50%;top: 18%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">注册邀請</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="lwInvitationForm" name="lwInvitationForm" class="form-horizontal"
                              action="${dynamicServer}/cms/invitation/save.do" method="post">
                            <input id="id" name="id" value="" type="hidden" title=""/>
                            <%--      <div class="form-group">
                                      <label class="col-sm-3 control-label">用户手机号：</label>
                                      <div class="col-sm-9">
                                          <input type="text" id="phone" name="phone" maxlength="256" class="col-xs-10 col-sm-7" placeholder=""
                                                 title="" value=""><label id="nameTip"></label>
                                      </div>
                                  </div>--%>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">用户数目：</label>
                                <div class="col-sm-9">
                                    <input type="number" id="userNum" name="userNum" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="0">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>
                                <div class="col-sm-9">

                                    <select name="courseNo" id="courseNo" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected"> 请选择</option>
                                        <c:forEach var="course" items="${courses}" varStatus="">

                                            <option value="${course.id}">${course.name}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程类型：</label>
                                <div class="col-sm-9">

                                    <select name="courseType" id="courseType" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected">直播</option>
                                        <option value="1">录播</option>
                                        <option value="2">面授</option>
                                        <option value="3">套餐</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-9">
                                    <select name="state" id="state" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected">启用</option>
                                        <option value="1">停用</option>
                                    </select>
                                </div>
                            </div>

                            <%--luoxiaosheng begin--%>
                            <div class="form-group">
                                <label class="col-sm-3 control-label ">活动图片:</label>
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
                                    <input type="hidden" id="actPhoto" name="actPhoto" value="">
                                    <a href="#icon-modal" class="btn btn-white btn-primary" data-toggle="modal"
                                       style="position: absolute;top: 2px;">
                                        <i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择图片
                                    </a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">活动介绍：</label>
                                <div class="col-sm-9">
                                        <textarea id="actIntroduce" name="actIntroduce" class="col-xs-12 col-sm-7"
                                                  rows="5"
                                                  placeholder="请输入活动描述..."
                                                  maxlength="500"></textarea>
                                    <label id="remarkTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label ">分享模板:</label>
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
                                    <input type="hidden" id="sharePhoto" name="sharePhoto" value="">
                                    <a href="#shareUrl-modal" class="btn btn-white btn-primary" data-toggle="modal"
                                       style="position: absolute;top: 2px;">
                                        <i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择图片
                                    </a>
                                </div>
                            </div>
                            <%--luoxiaosheng end--%>


                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary btn-sm" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 保存
                                    </button>
                                    &nbsp;&nbsp;
                                    <button class="btn btn-sm" type="button" data-dismiss="modal">
                                        <i class="ace-icon fa fa-undo bigger-110"></i> 取消
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%--<div id="modal-import" class="modal fade" tabindex="-21">--%>
<%--<div class="modal-dialog">--%>
<%--<div class="modal-content">--%>
<%--<div class="modal-header no-padding">--%>
<%--<div class="table-header">--%>
<%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">--%>
<%--<span class="white">&times;</span>--%>
<%--</button>--%>
<%--导入检查项--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="modal-body no-padding">--%>
<%--<div class="widget-box" style="border: none">--%>
<%--<div class="widget-body">--%>
<%--<div class="widget-main">--%>
<%--<div class="form-group">--%>
<%--<div class="col-xs-12" style="margin-bottom: 10px">--%>
<%--<span>请下载模板，按照模板格式整理数据：</span>--%>
<%--<a href="${staticServer}/upload/model/user-model-import.xls">导入检查项模板.xls</a>--%>
<%--</div>--%>
<%--</div>--%>
<%--<c:url value="${dynamicServer}/cms/invitation/import.do"--%>
<%--var="import_url"/>--%>
<%--<form:form action="${import_url}"--%>
<%--enctype="multipart/form-data" method="post" id="upload-form">--%>
<%--<div class="form-group">--%>
<%--<div class="col-xs-12">--%>
<%--<input name="excel_file" type="file" id="import-input"--%>
<%--accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>--%>

<%--</div>--%>
<%--<div class="col-xs-12" align="center">--%>
<%--<button class="btn btn-white btn-primary" type="submit">--%>
<%--<i class="ace-icon fa fa-cloud-upload bigger-110"></i> 确定--%>
<%--</button>--%>
<%--<button class="btn btn-white btn-primary" type="button" id="closeicon-modal"--%>
<%--data-dismiss="modal">--%>
<%--<i class="ace-icon fa fa-undo bigger-110"></i> 取消--%>
<%--</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</form:form>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="modal-footer no-margin-top"></div>--%>
<%--</div>--%>
<%--<!-- /.modal-content -->--%>
<%--</div>--%>
<%--<!-- /.modal-dialog -->--%>
<%--</div>--%>


<div id="icon-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    上传活动图片
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <c:url value="${uploadServer}/common/upload.do" var="upload_url"/>
                            <form:form action="${upload_url}"
                                       enctype="multipart/form-data" method="post" id="icon-form">
                                <input type="hidden" name="file_type" value="actPhoto">
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
                                <input type="hidden" name="file_type" value="sharePhoto">
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

<%@ include file="../../common/js.jsp" %>
<script src="${staticServer }/assets/js/jquery.form.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>

<script>
    window.UEDITOR_HOME_URL = '${staticServer}/assets/ueditor1.4.3/';
</script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.config.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.all.min.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/lang/zh-cn/zh-cn.js"></script>
<script src="${staticServer}/assets/components/fuelux/js/spinbox.js"></script>
<script src="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer}/assets/select2/select-topic-tags.js"></script>
<script src="${staticServer}/assets/select2/select2.full.js"></script>
<script>
    $(function () {
        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwInvitation");

        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.userNum = $("#userNumSearch").val();
                param.courseName = $("#courseNameSearch").val();
                param.page = data.start;
                param.length = data.length;
                return param;
            }
        };
        //object可以如下初始化表格
        window.table = $table_id.DataTable({
            dom: '<".table_area_top" B and >t<".table_area_bottom" pi>',
            Filter: false, //列筛序功能
            searching: false,//本地搜索
            ordering: false, //排序功能
            Info: true,//页脚信息
            lengthMenu: [15],
            scrollY: "auto",
            Paginate: true, //翻页功能
            sortable: false,
            processing: true,
            serverSide: true,
            ajax: function (data, callback) {//ajax配置为function,手动调用异步查询
                $.ajax({
                    type: "GET",
                    url: '${dynamicServer}/cms/invitation/getList.do',//请求数据的参数
                    data: userParam.getQueryCondition(data),
                    cache: false,  //禁用缓存
                    dataType: "json",
                    success: function (result) {
                        callback(result);
                    }
                });
            },
            //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
            //data 这里是固定不变的，id，name，age，sex等为你数据里对应的属性
            columns: [

                {
                    data: "userNum",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "courseName",
                    render: function (data) {
                        return data || "";
                    }
                },


                {
                    data: "courseType",
                    render: function (data) {
                        var type = "";
                        if (true) {
                            switch (data) {
                                case 0:
                                    type = "直播";
                                    break;
                                case 1:
                                    type = "录播";
                                    break;
                                case 2:
                                    type = "面授";
                                    break;
                                default:
                                    type = "套餐";
                            }
//                            type = (data == 1 ? "套餐" : "课程");
                        }
                        return type;
                    }
                },

                {
                    data: "state",
                    render: function (data) {
                        var state = "";
                        if (true) {
                            state = (data == 1 ? "停用" : "启动");
                        }
                        return state;
                    }
                },

                {
                    data: "id",
                    width: "155px",
                    render: function (data, type, row) {
                        return '<a class="btn  btn-sm btn-info" href="#modal-edit" data-toggle="modal"  data-backdrop="static" ' +
                            'onclick="updateInvitation(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>修改</a>' +
                            '&nbsp;&nbsp;' +
                            '<a class="btn btn-sm btn-danger" onclick="delInvitation(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>删除</a>';
                    }
                }


            ],
            language: { //国际语言转化
                aria: {
                    sortAscending: " - click/return to sort ascending",
                    sortDescending: " - click/return to sort descending"
                },
                lengthMenu: "显示 _MENU_ 记录",
                zeroRecords: "对不起，查询不到任何相关数据",
                emptyTable: "未有相关数据",
                loadingRecords: "正在加载数据-请等待...",
                info: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
                infoEmpty: "当前显示0到0条，共0条记录",
                infoFiltered: "（数据库中共为 _MAX_ 条记录）",
                processing: " 正在加载数据...",
                //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
                paginate: {
                    first: "首页",
                    previous: " 上一页 ",
                    next: " 下一页 ",
                    last: " 尾页 "
                }
            }
        });
        /*条件查询*/
        $("#btn-search").on("click", function () {
            table.draw();
        });
        /*validate验证*/
        $("#lwInvitationForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                userNum: {
                    required: true,
                    maxlength: 5
                }
            },
            submitHandler: function (form) {
                $("#lwInvitationForm").ajaxSubmit({
                    success: function () {
                        $('#modal-edit').modal('hide');
                        table.draw();
                    }
                });
            }
        });
    })
    ;

    /*新增时清空表单数据*/
    function flushForm() {
        //        清空活动图片数据
        $("#imageUl").addClass("hidden");
        $("[name=actPhoto]").val('');
        $("#icon-img").attr("src", "");

        //        清空活动图片上传file文件
        $("#icon-input").val('');

        //        清空分享图片数据
        $("#shareUrlUl").addClass("hidden");
        $("[name=sharePhoto]").val('');
        $("#shareUrl-img").attr("src", "");

        //        清空图片上传file文件
        $("#shareUrl-input").val('');

        $("#lwInvitationForm").find("input").each(function () {
            var id = $(this).attr("id");
            $("#" + id).val("");
        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/invitation/findAll.do",
            contentType: "application/json",
            success: function (data) {

            }
        })
    }


    /*修改时需要回显数据*/
    function updateInvitation(id) {
        flushForm();
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/cms/invitation/findOne.do",
            data: {
                "id": id
            },
            contentType: 'application/json',
            success: function (data) {
                for (var key in data) {
                    $("#" + key).val(data[key]);

                    if (key == "actPhoto" && data[key] != "") {
                        var img_path = data[key];
                        var img_url = '${imageServer}' + img_path;
                        var $shareUrl_img = $("#icon-img");
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#imageUl").removeClass("hidden");
                    }
                    if (key == "sharePhoto" && data[key] != "") {
                        var img_path = data[key];
                        var img_url = '${imageServer}' + img_path;
                        var $shareUrl_img = $("#shareUrl-img");
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#shareUrlUl").removeClass("hidden");
                    }
                }

            }
        });
    }

    /*删除*/
    function delInvitation(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该注冊信息？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/invitation/delete.do",
                    data: {
                        "id": id
                    },
                    contentType: 'application/json',
                    success: function () {
                        table.draw();
                    }
                });
            }
        });
    }

    function stateOption(data) {
        var x = "";
        <%--//0正常 1删除  2 禁用 3 审核中--%>
        console.log(data);
        switch (data) {
            case 0:
                x = "正常";
                break;
            case 1:
                x = "删除";
                break;
            case 2:
                x = "禁用";
                break;
            case 3:
                x = "审核中";
                break;
            case 4 :
                x = "审核通过";
                break;
        }
        return x;
    }

    function isApp(data) {
        var x = "";
//        1 是0 否
        switch (data) {
            case 0:
                x = "否";
                break;
            case 1:
                x = "是";
                break;

        }
        return x;

    }

    //活动图片
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
                    $("[name=actPhoto]").val(img_path);
                    var img_url = '${imageServer}' + img_path;

                    var $icon_img = $("#icon-img");
                    if ($icon_img.attr("src") != '') {
                        $.ajax({
                            url: '${uploadServer}/common/delFile.do',
                            data: {
                                path: $icon_img.attr("data-path")
                            },
                            type: 'GET',
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
                    $("[name=actPhoto]").val('');
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
                    $("[name=sharePhoto]").val(img_path);
                    var img_url = '${imageServer}' + img_path;

                    var $shareUrl_img = $("#shareUrl-img");
                    if ($shareUrl_img.attr("src") != '') {
                        $.ajax({
                            url: '${uploadServer}/common/delFile.do',
                            data: {
                                path: $shareUrl_img.attr("data-path")
                            },
                            type: 'GET',
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
                    $("[name=sharePhoto]").val('');
                    $("#shareUrl-img").attr("src", "");
                } else {
                    $.notify({message: "文件路径错误!", z_index: 15111});
                }
            }
        })
    });
</script>
</body>
</html>


