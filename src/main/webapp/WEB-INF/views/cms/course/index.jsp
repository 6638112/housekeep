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
    <title>${webTitle }-
        <c:if test="${type==0}">直播课程</c:if>
        <c:if test="${type==1}">录播课程</c:if>
        <c:if test="${type==2}">面授课程</c:if>
        <c:if test="${type==3}">套餐课程</c:if>
    </title>
    <%@ include file="../../common/header.jsp" %>
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
                                                    <label class="control-label col-xs-6 col-lg-5">课程名称：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="nickNameSearch"
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
                                                       onclick="addLwCourse()" id="btn-add">
                                                        <i class="ace-icon fa fa-search"></i> 新增
                                                    </a>
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
                                <table id="lwCourse" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="background-color: #E5E5E5">ID</th>
                                        <th style="background-color: #E5E5E5">课程名称</th>
                                        <th style="background-color: #E5E5E5">排序</th>
                                        <th style="background-color: #E5E5E5">开课时间</th>
                                        <th style="background-color: #E5E5E5">结课时间</th>
                                        <th style="background-color: #E5E5E5">课程金额</th>
                                        <th style="background-color: #E5E5E5">实际销售人数</th>
                                        <th style="background-color: #E5E5E5">是否抢购</th>
                                        <th style="background-color: #E5E5E5">是否邮寄</th>
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
<%@ include file="../../common/js.jsp" %>
<script>
    $(function () {
        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwCourse");
        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.name = $("#nickNameSearch").val();
                param.type = ${type};
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
                    url: '${dynamicServer}/cms/course/getList.do',//请求数据的参数
                    data: userParam.getQueryCondition(data),
                    cache: false,  //禁用缓存
                    dataType: "json",
                    success: function (result) {
                        callback(result);
                    }
                });
            },
            columns: [
                {
                    data: "id",
                    render: function (data) {
                        return data || "无";
                    }
                }, {
                    data: "name",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "sort",
                    render: function (data) {
                        return data || "0";
                    }
                },
                {
                    data: "startDate",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "endDate",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "finalAmount",
                    render: function (data) {
                        return data || "0";
                    }
                },
                {
                    data: "realEnrollment",
                    render: function (data) {
                        return data || "0";
                    }
                },
                {
                    data: "status",
                    render: function (data) {
                        switch (data) {
                            case 0 :
                                return "否";
                                break;
                            case 1 :
                                return "是";
                                break;
                            default :
                                return "否";
                                break;
                        }
                    }
                },
                {
                    data: "isSend",
                    render: function (data) {
                        switch (data) {
                            case 0 :
                                return "否";
                                break;
                            case 1 :
                                return "是";
                                break;
                            default :
                                return "否";
                                break;
                        }
                    }
                },
                {
                    data: "state",
                    render: function (data) {
                        switch (data) {
                            case 0 :
                                return "未上架";
                                break;
                            case 1 :
                                return "销售中";
                                break;
                            case 2 :
                                return "已停售";
                                break;
                            case 3 :
                                return "已下架";
                                break;
                            default :
                                return "未知状态";
                                break;

                        }
                    }
                },
                {
                    data: "id",
                    width: "280px",
                    render: function (data, type, row) {
                        var button = '<a class="btn  btn-sm btn-info" onclick="updateLwCourse(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>修改</a>';
                        if (row.state == 0 || row.state == 2 || row.state == 3) {
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="putaway(\'' + data + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>上架</a>';
                        } else if (row.state == 1) {
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="soldOut(\'' + data + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>下架</a>';
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="discontinued(\'' + data + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>停售</a>';
                        }
                        button += '&nbsp;&nbsp;<a class="btn btn-sm btn-danger" onclick="delLwCourse(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>删除</a>';
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
    });

    function addLwCourse() {
        window.location.href = "${dynamicServer}/cms/course/toAdd.do?type=" +${type};
    }

    function updateLwCourse(id) {
        window.location.href = "${dynamicServer}/cms/course/toUpdate.do?id=" + id + "&type=" +${type};
    }

    /*删除*/
    function delLwCourse(id) {
        var context = '确定要删除课程？'
//        查询关联内容/**/
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/cms/course/relation.do",
            data: {
                "courseNo": id
            },

            contentType: 'application/json',
            success: function (data) {
                console.log(data);
                if (data!= '') {

                    context = "已关联"+data + context;
                    console.log(context);
                }
                bootbox.confirm("<a style='font-size: 17px;color: red'>" + context + "</a>", function (result) {
                    if (result) {
                        $.ajax({
                            type: "GET",
                            url: "${dynamicServer}/cms/course/delete.do",
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
        });


    }

    /*上架*/
    function putaway(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要上架课程？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/course/putaway.do",
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

    /*下架*/
    function soldOut(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要下架课程？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/course/soldOut.do",
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

    /*停售*/
    function discontinued(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要停售课程？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/course/discontinued.do",
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


