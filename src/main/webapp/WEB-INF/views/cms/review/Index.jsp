<%--
  Created by IntelliJ IDEA.
  User: xiaoxiao
  Date: 2017/7/18
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../common/taglib.jsp" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-评价管理</title>
    <%@ include file="../../common/header.jsp" %>
    <link href="${staticServer}/assets/components/raty/lib/jquery.raty.css" rel="stylesheet"/>
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
                                                    <label class="control-label col-xs-6 col-lg-5">手机号：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="PhoneSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">关键字：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="KeywordSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">课程名称：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="CourseSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">星级：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <select name="StarSearch" id="StarSearch">
                                                            <option value="">请选择</option>
                                                            <option value="1">1星</option>
                                                            <option value="2">2星</option>
                                                            <option value="3">3星</option>
                                                            <option value="4">4星</option>
                                                            <option value="5">5星</option>
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
                                                    <%--<a type="button" class="btn btn-success btn-sm"--%>
                                                       <%--href="#modal-edit" data-toggle="modal"--%>
                                                       <%--data-backdrop="static" onclick="flushForm()"--%>
                                                       <%--id="btn-add">--%>
                                                        <%--<i class="ace-icon fa fa-plus"></i> 新增--%>
                                                    <%--</a>--%>
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
                                <table id="review" class="table table-striped table-bordered table-hover"
                                       style="width: 100%">
                                    <thead>
                                    <tr>
                                        <th style="background-color: #E5E5E5">学员</th>
                                        <th style="background-color: #E5E5E5">类型</th>
                                        <th style="background-color: #E5E5E5">对象</th>
                                        <th style="background-color: #E5E5E5">星级</th>
                                        <th style="background-color: #E5E5E5">内容</th>
                                        <th style="background-color: #E5E5E5">时间</th>
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
<div id="modal-edit" class="modal fade" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 50%;top: 4%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">编辑评价</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="reviewForm" name="reviewForm" class="form-horizontal"
                              action="${dynamicServer}/portal/review/save.do" method="post">
                            <input id="id" name="id" value="" type="hidden" title=""/>
                            <%--<div class="form-group">--%>
                                <%--<label class="col-sm-3 control-label">评价星级：</label>--%>
                                <%--<div class="col-sm-9">--%>
                                    <input type="hidden" id="starReview" name="starReview"/>
                                    <%--<div class="rating" style="margin-top: 12px"></div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="col-sm-3 control-label">外部编号：</label>--%>
                                <%--<div class="col-sm-9">--%>
                            <input type="hidden" id="teacherNo" name="teacherNo"/>
                                    <input type="hidden" id="externalNumber" name="externalNumber"/>
                                           <%--title="" value=""><label id="externalNumberTip"></label>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">评价内容：</label>
                                <div class="col-sm-9">
                                        <textarea id="reviewContent" name="reviewContent" class="col-xs-12 col-sm-7"
                                                  rows="5"
                                                  placeholder="请输入评价内容..."
                                                  maxlength="500" readonly></textarea>
                                    <label id="reviewContentTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">回复内容：</label>
                                <div class="col-sm-9">
                                        <textarea id="replyContent" name="replyContent" class="col-xs-12 col-sm-7"
                                                  rows="5"
                                                  placeholder="请输入回复内容..."
                                                  maxlength="500"></textarea>
                                    <label id="replyContentTip"></label>
                                </div>
                            </div>
                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary btn-sm" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 保存
                                    </button>&nbsp;&nbsp;
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

<%@ include file="../../common/js.jsp" %>
<script src="${staticServer }/assets/js/jquery.form.js"></script>
<script src="${staticServer }/assets/components/raty/lib/jquery.raty.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>
<script>
    $(function () {
        //评价星级
        $('.rating').raty({
            'cancel': false,
            'half': false,
            'starType': 'i',
            'number': 5,
            'score': function () {
                return $(this).attr('data-score');
            },
            'click': function (score, evt) {
                console.log(score);
                $("#starReview").val(score);
            }
        })

        /*把要初始化的table的对象赋值*/
        var $table_id = $("#review");
        /*自定义查询参数*/
        var reviewParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.phone = $("#PhoneSearch").val();
                param.keyword = $("#KeywordSearch").val();
                param.courseName = $("#CourseSearch").val();
                param.starReview = $("#StarSearch").val();
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
            scrollX: "auto",
            scrollY: "auto",
            Paginate: true, //翻页功能
            sortable: false,
            processing: true,
            serverSide: true,
            ajax: function (data, callback) {//ajax配置为function,手动调用异步查询
                $.ajax({
                    type: "GET",
                    url: '${dynamicServer}/portal/review/getList.do',//请求数据的参数
                    data: reviewParam.getQueryCondition(data),
                    cache: false,  //禁用缓存
                    dataType: "json",
                    success: function (result) {
                        callback(result);
                    }
                });
            },
            columns: [
                {
                    data: "phone",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "type",
                    render: function (data) {
                        switch (data) {
                            case 1:
                                return "课程";
                                break;
                            case 2:
                                return "订单";
                                break;
                            default:
                                return "";
                        }
                    }
                },
                {
                    data: "courseName",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "starReview",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "reviewContent",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "reviewDate",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "id",
                    width: "215px",
                    render: function (data, type, row) {
                        return '<a class="btn  btn-sm btn-info" href="#modal-edit" data-toggle="modal"  data-backdrop="static" ' +
                            'onclick="updatereview(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>回复评价</a>' +
                            '&nbsp;&nbsp;' +
                            '<a class="btn btn-sm btn-danger" onclick="delreview(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>隐藏评价</a>';
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
        $("#reviewForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                starReview: {
                    required: true,
                    maxlength: 11,
                    digits: true

                },
                type: {
                    required: true,
                    maxlength: 1
                },
                reviewContent: {
                    required: true,
                    maxlength: 255
                }
            },
            submitHandler: function () {
                $("#reviewForm").ajaxSubmit({
                    success: function () {
                        $('#modal-edit').modal('hide');
                        table.draw();
                    }
                });
            }
        });
    });


    /*新增时清空表单数据*/
    function flushForm() {
        //$("#id").removeAttr("rel");
        $("#reviewForm").find("input,select,textarea").each(function () {
            var id = $(this).attr("id");
            $("#" + id).val("");
        });
    }

    /*修改时需要回显数据*/
    function updatereview(id) {
        flushForm();
       // $("#id").attr("rel", "true");
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/portal/review/findOne.do",
            data: {
                "id": id
            },
            contentType: 'application/json',
            success: function (data) {
                for (var key in data) {
                    $("#" + key).val(data[key]);
                }

            }
        });
    }

    /*删除*/
    function delreview(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要隐藏该检查项信息？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/portal/review/delete.do",
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

