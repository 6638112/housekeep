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
    <title>${webTitle }-发货管理</title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
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
                                                    <label class="control-label col-xs-6 col-lg-5">订单号：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="externalNoSearch"
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
                                                    <label class="control-label col-xs-6 col-lg-5">姓名：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="userNameSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">资料名称：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="goodsNameSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">订单状态：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <select name="statusSearch" id="statusSearch" class="col-sm-12 col-lg-7" title="">
                                                            <option value="" selected="selected">请选择</option>
                                                            <option value="0">未发货</option>
                                                            <option value="1">已发货</option>
                                                            <option value="2">已通知</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">订单类型：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <select name="statusSearch" id="typeSearch" class="col-sm-12 col-lg-7" title="">
                                                            <option value="" selected="selected">请选择</option>
                                                            <option value="1">课程</option>
                                                        </select>
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
                                                    <a href="#modal-export" class="btn btn-warning btn-sm"
                                                       data-toggle="modal">
                                                        <i class="ace-icon fa fa-file-excel-o"></i>单号打印</a>
                                                    &nbsp;&nbsp;
                                                    <a href="#modal-import" class="btn btn-warning btn-sm"
                                                       data-toggle="modal">
                                                        <i class="ace-icon fa fa-file-excel-o"></i>批量导入</a>
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
                                <table id="lwOrder" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="background-color: #E5E5E5">订单号</th>
                                        <th style="background-color: #E5E5E5">资料名称</th>
                                        <th style="background-color: #E5E5E5">收件人</th>
                                        <th style="background-color: #E5E5E5">费用</th>
                                        <th style="background-color: #E5E5E5">类型</th>
                                        <th style="background-color: #E5E5E5">状态</th>
                                        <th style="background-color: #E5E5E5">快递单号</th>
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



<%--order delivery--%>
<div id="modal-delivery" class="modal fade" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 50%;top: 18%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">订单发货</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="lwVoucherForm" name="lwVoucherForm" class="form-horizontal"
                              action="${dynamicServer}/cms/delivery/updateState.do" method="post">
                            <input id="orderNumber" name="orderNumber" value="" type="hidden" title=""/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">快递公司：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="deliveryCompany" name="deliveryCompany" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="" required>
                                    <label id="deliveryCompanyTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">快递单号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="deliveryNumber" name="deliveryNumber" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="" required>
                                    <label id="deliveryNumberTip"></label>
                                </div>
                            </div>


                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary btn-sm" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 提交
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

<%--export pop--%>
<div id="modal-export" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    导出选择项
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <c:url value="${dynamicServer}/cms/delivery/export.do"
                                   var="import_url"/>
                            <form:form id="exportForm" action="${import_url}" method="post">
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <select name="courseNo" id="courseNo" class="col-sm-12 col-lg-7" style="width: 58.5%" title="">
                                            <%--<script>--%>
                                                <%--var $option = $('<option selected></option>');--%>
                                                <%--$option.val("").text('所有订单');--%>
                                                <%--$("#courseNo").append($option);--%>
                                                <%--$option.removeData();--%>
                                                <%--$("#courseNo").trigger('change');--%>
                                            <%--</script>--%>
                                                <option value="" selected="selected"> 所有未发货订单</option>
                                                <c:forEach var="course" items="${courses}" varStatus="">

                                                <option value="${course.name}" >${course.name}</option>
                                                </c:forEach>
                                        </select>

                                    </div>

                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" id="export-button" type="submit">
                                            <i class="ace-icon fa fa-cloud-upload bigger-110"></i> 确定
                                        </button>
                                        <button class="btn btn-white btn-primary" type="button" id="closeicon-modal2"
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

<%-- import pop--%>
<div id="modal-import" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    导入检查项
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <div class="form-group">
                                <div class="col-xs-12" style="margin-bottom: 10px">
                                    <span>请下载模板，按照模板格式整理数据：</span>
                                    <a href="${staticServer}/upload/model/lwgk-批量发货模板.xls">lwgk-批量发货模板.xls</a>
                                </div>
                            </div>
                            <c:url value="${dynamicServer}/cms/delivery/import.do"
                                   var="import_url"/>
                            <form:form action="${import_url}"
                                       enctype="multipart/form-data" method="post" id="upload-form">
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input name="excel_file" type="file" id="import-input"
                                               accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>

                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="submit">
                                            <i class="ace-icon fa fa-cloud-upload bigger-110"></i> 确定
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

<div id="import-result-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    导入结果
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <div class="form-group">
                            </div>
                            <form:form action="" id="import-result-form">
                                <div class="form-group">
                                    <div class="col-xs-12" id="result-text">
                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="button" id="result-btn">
                                            <i class="ace-icon fa fa-check bigger-110"></i> 确认
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

<script src="${staticServer}/assets/select2/select-topic-tags.js"></script>
<script src="${staticServer}/assets/select2/select2.full.js"></script>
<script>
    var $lwCourseIds = $('#courseNo');
    $(function () {

        <%--/*下拉选择课程*/--%>
        <%--$lwCourseIds.select2({--%>
            <%--tags: true,--%>
            <%--multiple: true,--%>
            <%--createTag: function (params) {--%>
                <%--console.log(arguments);--%>
                <%--return null;--%>
            <%--},--%>
            <%--placeholder: '请输入要关联的课程',--%>
            <%--language: {--%>
                <%--noResults: function () {--%>
                    <%--return '没有找到该课程';--%>
                <%--},--%>
                <%--inputTooShort: function () {--%>
                    <%--return '请至少输入1个字符';--%>
                <%--}--%>
            <%--},--%>
            <%--ajax: {--%>
                <%--url: "${dynamicServer}/cms/course/getListByName.do",--%>
                <%--type: "get",--%>
                <%--dataType: 'json',--%>
                <%--delay: 250,--%>
                <%--data: function (params) {--%>
                    <%--return {--%>
                        <%--name: params.term,--%>
                        <%--page: params.page--%>
                    <%--};--%>
                <%--},--%>
                <%--processResults: function (data, params) {--%>
                    <%--params.page = params.page || 1;--%>

                    <%--return {--%>
                        <%--results: data--%>
                    <%--};--%>
                <%--},--%>
                <%--cache: true--%>
            <%--},--%>
            <%--escapeMarkup: function (markup) {--%>
                <%--return markup;--%>
            <%--},--%>
            <%--minimumInputLength: 1,--%>
            <%--templateResult: function (course) {--%>
                <%--return course.name|| course.text;--%>
            <%--},--%>
            <%--templateSelection: function (course) {--%>
                <%--return course.name|| course.text;--%>
            <%--}--%>
        <%--});--%>


        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwOrder");
        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.orderNo = $("#externalNoSearch").val();
                param.phone = $("#phoneSearch").val();
                param.userName = $("#userNameSearch").val();
                param.goodsName = $("#goodsNameSearch").val();
                param.status = $("#statusSearch").val();
                param.type = $("#typeSearch").val();

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
                    url: '${dynamicServer}/cms/delivery/getList.do',//请求数据的参数
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
                    data: "orderNo",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "goodsName",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "userName",
                    render: function (data,type,row) {
                        return (data||"")+"+"+(row.phone||"")+"+"+(row.province||"")+(row.city||"")+(row.address||"");
                    }
                },
                {
                    data: "finalAmount",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "type",
                    render: function (data) {
                        var state = "";
                        switch (data) {

                            case 1:
                                state = "课程";
                                break;
                            default :
                                state = "课程";
                                break;
                        }
                        return state;
                    }
                },
                {
                    data: "status",
                    render: function (data) {
                        var state = "";
                        switch (data) {
                            case 0:
                                state = "未发货";
                                break;
                            case 1:
                                state = "已发货";
                                break;
                            case 2:
                                state = "已通知";
                                break;
                            default :
                                state = "未发货";
                                break;
                        }
                        return state;
                    }
                },
                {
                    data: "deliveryNumber",
                    render: function (data, type, row) {
                        return ((row.deliveryCompany&&data)==null?"无":row.deliveryCompany+"+"+data)||"无";
                    }
                },
                {
                    data: "id",
                    width: "295px",
                    render: function (data, type, row) {
                        var button = '<a class="btn  btn-sm btn-success" href="#modal-edit" data-toggle="modal"  data-backdrop="static" ' +
                            'onclick="checkDepartment(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>详情</a>' ;
                        button += '&nbsp;&nbsp;' +'<a class="btn  btn-sm btn-warning" href="#modal-edit" data-toggle="modal"  data-backdrop="static" ' +
                            'onclick="updateDepartment(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>修改</a>' ;
                        if (row.status == 0) {
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-info" href="#modal-delivery" data-toggle="modal" data-backdrop="static" onclick="updateDelivery(\'' + row.orderNo  + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>发货</a>';
                        }
//                        if (row.status !=2) {
//                            button += '&nbsp;&nbsp;' +
//                                '<a class="btn btn-sm btn-danger" onclick="delDepartment(\'' + data + '\')">' +
//                                '<i class="ace-icon fa fa-pencil-square-o "></i>删除</a>';
//                        }
                        return button;
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
        $("#lwOrderForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                code: {
                    required: true,
                    maxlength: 255
                },
                name: {
                    required: true,
                    maxlength: 255
                }
            },
            submitHandler: function (form) {
                $("#lwOrderForm").ajaxSubmit({
                    success: function () {
                        $('#modal-edit').modal('hide');
                        table.draw();
                    }

                });
            }
        });


        /*发货validate验证*/
        $("#lwVoucherForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                deliveryCompany: {
                    required: true,
                },
                deliveryNumber: {
                    required: true,
                }

            },
            submitHandler: function (form) {
                $("#lwVoucherForm").ajaxSubmit({
                    success: function (result) {
                        $('#modal-delivery').modal('hide');
                        table.draw();

                    }
                });

            }
        });
    });

    var $import_input = $('#import-input');
    var $export_input = $('#export-input');

    $import_input.ace_file_input({
        style: 'well',
        btn_choose: '点击选择Excel文件',
        btn_change: null,
        no_icon: 'ace-icon fa fa-file-excel-o',
        droppable: false,
        thumbnail: 'small',//large | fit
        maxSize: 10240000,
        allowExt: ['xls', 'xlsx', 'xlt', 'xlw', 'xlc', 'xlm'],
        allowMime: ['application/vnd.ms-excel', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'],
        before_remove: function () {
            return true;
        }

    }).on('change', function () {
        if ($import_input.val() == '') {
            resetFileinput();
            return false;
        }
    }).on('file.error.ace', function (ev, info) {
        if (info.error_count['ext'] || info.error_count['mime']) {
            $.notify("请选择Excel文件!");
            return false;
        }
        if (info.error_count['size']) {
            $.notify("文件不超过100M!");
            return false;
        }
    });

    $export_input.ace_file_input({
        style: 'well',
        btn_choose: '点击选择文件地址',
        btn_change: null,
        no_icon: 'ace-icon fa fa-file-excel-o',
        droppable: false,
        thumbnail: 'small',//large | fit
        maxSize: 10240000,
        allowExt: ['xls', 'xlsx', 'xlt', 'xlw', 'xlc', 'xlm'],
        allowMime: ['application/vnd.ms-excel', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'],
        before_remove: function () {
            return true;
        }

    }).on('change', function () {
        if ($export_input.val() == '') {
            resetFileinput();
            return false;
        }
    }).on('file.error.ace', function (ev, info) {
        if (info.error_count['ext'] || info.error_count['mime']) {
            $.notify("请选文件夹!");
            return false;
        }
        if (info.error_count['size']) {
            $.notify("文件不超过100M!");
            return false;
        }
    });

    $("#export-button").on('click', function () {
        setTimeout(function(){
            var msg = '';
            msg += '导出成功';
            $('#modal-export').modal('hide');
            $("#result-text").html(msg);
            $("#import-result-modal").modal("show");
            },2000);
    });
    /*导出validate验证*/
    $("#eeeexportForm").validate({
        errorElement: "label",
        errorClass: "validError",
        errorPlacement: function (error, element) {
            error.appendTo($("#" + element.attr('id') + "Tip"));
        },
        rules: {

        },
        submitHandler: function (form) {
            $("#exportForm").ajaxSubmit({
                success: function (result) {
                    $('#modal-export').modal('hide');
                    alert("导出成功");
                    table.draw();

//                    /*验证导出是否成功*/
//                    $export_input.ace_file_input('loading', false);
//                    var msg = '';
//                    if (result && result.success) {
//                        $("#modal-export").modal("hide");  //关闭上传窗口
//                        $export_input.val('');
//                        resetFileinput();
//
////                        if (result.data.length == 0) {
////                            msg = result.message;
////                        } else {
////                            $.each(result.data, function (i, item) {
////                                var index = parseInt(item.rowIndex);
////                                msg += '第' + index + '行,' + item.reason + '<br/>';
////                            });
//                            msg += '导出成功';
////                        }
//                        $("#result-text").html(msg);
//                        $("#import-result-modal").modal("show");
////
//                        //$.notify(msg);
//                    } else {
//                        $("#modal-import").modal("hide");   //关闭上传窗口
//                        $export_input.val('');
//                        resetFileinput();
//                        $export_input.ace_file_input('loading', false);
//                    }
                },
                error: function(){
                    alert("导出失败");
                }
            });
        }
    });

    var subject_upload_form = $("#upload-form");
    //导入提交
    subject_upload_form.on('submit', function () {
        var upload_check = $import_input.val();
        if (upload_check == '') {
            resetFileinput();
            $.notify("请选择文件!");
            return false;
        }
        $import_input.ace_file_input('loading', true);
        $(".ace-file-overlay").append('<div class="overlay-text">正在导入中...</div>');
        subject_upload_form.ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: subject_upload_form.attr('action'),
            dataType: 'json',
            success: function (result) {
                $import_input.ace_file_input('loading', false);
                var msg = '';
                if (result && result.success) {
                    $("#modal-import").modal("hide");  //关闭上传窗口
                    $import_input.val('');
                    resetFileinput();

                    if (result.data.length == 0) {
                        msg = result.message;
                    } else {
                        $.each(result.data, function (i, item) {
                            var index = parseInt(item.rowIndex);
                            msg += '第' + index + '行,' + item.reason + '<br/>';
                        });
                        msg += '其余导入成功';
                    }
                    $("#result-text").html(msg);
                    $("#import-result-modal").modal("show");
//
                    //$.notify(msg);
                } else {
                    $("#modal-import").modal("hide");   //关闭上传窗口
                    $import_input.val('');
                    resetFileinput();
                    $import_input.ace_file_input('loading', false);
                }
            }
        });
        return false;
    });
    $("#result-btn").on('click', function () {
        $("#import-result-modal").modal("hide");
        table.draw();
    });


    //重置上传窗口

    function resetFileinput() {
        var $import_input = $("#upload-form");
        $import_input.parent().find(".ace-file-container").removeClass("hide-placeholder").removeClass("selected");
        $import_input.parent().find(".ace-file-container").attr("data-title", '点击选择Excel文件');
        $import_input.parent().find(".ace-file-name").find("i").addClass("fa-file-excel-o").removeClass("fa-file");
        $import_input.parent().find(".ace-file-name").find("img").remove();
        $import_input.parent().find(".ace-file-name").attr("data-title", 'No File ...');
    }

    /*订单发货*/
    function updateDelivery(id) {
        $("#orderNumber").val(id);
    }

    /*查看详情*/
    function checkDepartment(id) {
        window.location.href = "${dynamicServer}/cms/delivery/toUpdate.do?id=" + id+"&check=1";
    }

    /*跳转页面修改数据*/
    function updateDepartment(id) {
        window.location.href = "${dynamicServer}/cms/delivery/toUpdate.do?id=" + id;
    }
    <%--/*修改时需要回显数据*/--%>
    <%--function updateDepartment(id) {--%>

        <%--$.ajax({--%>
            <%--type: "GET",--%>
            <%--url: "${dynamicServer}/cms/order/toUpdate.do",--%>
            <%--data: {--%>
                <%--"id": id--%>
            <%--},--%>
            <%--contentType: 'application/json',--%>
            <%--success: function (data) {--%>
                <%--for (var key in data) {--%>
                    <%--$("#" + key).val(data[key]);--%>
                <%--}--%>

            <%--}--%>
        <%--});--%>
    <%--}--%>

    /*删除*/
    function delDepartment(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该订单发货信息？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/delivery/delete.do",
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

</script>
</body>
</html>


