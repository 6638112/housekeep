<%--
  Created by IntelliJ IDEA.
  User: 1553280431@qq.com
  Date: 2017/5/25
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="../../../common/taglib.jsp" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-面授章节</title>
    <%@ include file="../../../common/header.jsp" %>
    <link type="text/css" href="${staticServer }/assets/components/jquery-ui/jquery-ui.css" rel="stylesheet"/>
    <link type="text/css" href="${staticServer }/assets/layui/layui/css/layui.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/select2/4.0.3/css/select2.css" rel="stylesheet">

</head>

<body class="no-skin">
<%@ include file="../../../common/top.jsp" %>
<div class="main-container" id="main-container">
    <%@ include file="../../../common/menu.jsp" %>
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
                                                        <input type="text" id="courseNameSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">章节名称：</label>

                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="titleSearch"
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
                                                       id="btn-add"><i class="ace-icon fa fa-search"></i> 新增

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
                                <table id="lwCourseChapter" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>

                                        <th style="background-color: #E5E5E5">课程名称</th>
                                        <th style="background-color: #E5E5E5">章节名称</th>
                                        <th style="background-color: #E5E5E5">开始时间</th>
                                        <th style="background-color: #E5E5E5">结束时间</th>
                                        <th style="background-color: #E5E5E5">排序</th>

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
    <div class="modal-dialog" style="width: 50%;top: 18%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">用户</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="lwCourseChapterForm" name="lwCourseChapterForm" class="form-horizontal"
                              action="${dynamicServer}/cms/coursechapter/save.do?chapterType=0" method="post">

                            <input id="id" name="id" value="" type="hidden" title=""/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>

                                <div class="col-sm-9">


                                    <select name="courseId" id="courseId" class="col-sm-12 col-lg-7" title="">

                                        <c:forEach var="course" items="${courses}" varStatus="">
                                            <option value="${course.id}">${course.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">章节名称：</label>

                                <div class="col-sm-9">
                                    <input type="text" id="title" name="title" maxlength="256"
                                           class="col-xs-10 col-sm-7"
                                           placeholder=""
                                           title="" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-9">
                                    <input id="startDate" name="startDate" class="Wdate col-xs-12 col-sm-7 " type="text"
                                           style="height: 40px" onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>


                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">结束时间：</label>
                                <div class="col-sm-9">
                                    <input id="endDate" name="endDate" class="Wdate col-xs-12 col-sm-7 " type="text"
                                           style="height: 40px" onclick="WdatePicker({dateFmt:'yyyy.MM.dd HH:mm'})"/>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">排序：</label>

                                <div class="col-sm-9">
                                    <input type="number" id="sort" name="sort" maxlength="5" class="col-xs-10 col-sm-7"
                                           placeholder=""
                                           title="" value="">
                                </div>
                            </div>


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


<%@ include file="../../../common/js.jsp" %>
<%--<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>--%>
<script src="${staticServer }/assets/js/jquery.form.js"></script>
<script src="${staticServer }/assets/components/jquery-ui/jquery-ui.js"></script>
<link href="http://cdn.bootcss.com/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.css" rel="stylesheet">
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.js"></script>


<script src="http://cdn.bootcss.com/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.js"></script>
<script src="http://cdn.bootcss.com/jquery-ui-timepicker-addon/1.6.3/i18n/jquery-ui-timepicker-zh-CN.js"></script>
<script src="https://cdn.bootcss.com/select2/4.0.3/js/select2.js"></script>
<script src="https://cdn.bootcss.com/select2/4.0.3/js/i18n/zh-CN.js"></script>
<script src="${staticServer}/assets/My97DatePicker/WdatePicker.js"></script>

<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>
<script>

</script>
<script>


    $(function () {

        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwCourseChapter");
        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.courseName = $("#courseNameSearch").val();
                param.title = $("#titleSearch").val();
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
//                    面授章节
                    url: '${dynamicServer}/cms/coursechapter/getList.do?chapterType=0&courseType=2',//请求数据的参数
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
                    data: "courseName",
                    render: function (data) {
                        return data || "无";
                    }
                },

                {
                    data: "title",
                    render: function (data) {
                        return data || "无";
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
                    data: "id",
                    width: "155px",
                    render: function (data, type, row) {
                        return '<a class="btn  btn-sm btn-info" href="#modal-edit" data-toggle="modal"  data-backdrop="static" ' +
                            'onclick="updateDepartment(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>修改</a>' +
                            '&nbsp;&nbsp;' +
                            '<a class="btn btn-sm btn-danger" onclick="delDepartment(\'' + data + '\')">' +
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
        $("#lwCourseChapterForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {

                title: {
                    required: true,
                    maxlength: 255
                }
            },
            submitHandler: function (form) {
                console.log($("form").attr("action"));

                $("#lwCourseChapterForm").ajaxSubmit({
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
        $("#lwCourseChapterForm").find("input").each(function () {
            var id = $(this).attr("id");
            $("#" + id).val("");
        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/coursechapter/findAll.do",
            contentType: "application/json",
            success: function (data) {

            }
        })
    }
    /*修改时需要回显数据*/
    function updateDepartment(id) {
        flushForm();
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/cms/coursechapter/findOne.do",
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
    function delDepartment(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该课程章节？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/coursechapter/delete.do",
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
    function mediaType(data) {
//        0:视频课 1:音频课
        var x = "";

        switch (data) {
            case 0:
                x = "视频课";
                break;
            case 1:
                x = "音频课";
                break;

        }
        return x;
    }
    function Ptype(data) {
//        1:一对一课 2:班课
        var x = "";

        switch (data) {
            case 1:
                x = "一对一课";
                break;
            case 2:
                x = "班课";
                break;

        }
        return x;
    }

</script>
</body>
</html>


