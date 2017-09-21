<%@ include file="../../common/taglib.jsp" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-版本管理</title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/select2/select2.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/css/uploadifive.css"/>
    <style>
        .modal {
            z-index: 5;
        }
        .modal-backdrop {
            z-index: 4;
        }
        .modal-backdrop.in {
            z-index: 3;
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
                                                    <label class="control-label col-xs-6 col-lg-5">版本号：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="NameSearch"
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
                                        <th style="background-color: #E5E5E5">ID</th>
                                        <th style="background-color: #E5E5E5">版本号</th>
                                        <th style="background-color: #E5E5E5">文件路径</th>
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

<%--voucher add--%>
<div id="modal-edit" class="modal fade" role="dialog" aria-hidden="true" style="overflow-y: auto !important;">
    <div class="modal-dialog" style="width: 50%;top: 18%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">新增版本</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="lwInvitationForm" name="lwInvitationForm" class="form-horizontal"
                              action="${dynamicServer}/cms/version/save.do" method="post">
                            <input id="id" name="id" value="" type="hidden" title=""/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">版本号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="versionNo" name="versionNo" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="">
                                    <label id="versionNoTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label ">上传文件:</label>
                                <div class="col-sm-9 control-div">
                                    <div class="col-xs-12">
                                        <input name="file" type="file" id="icon-input" class="uploadifive"/>
                                    </div>
                                    <div id="tip-queue"></div>
                                    <input type="hidden" id="fileAddress" name="fileAddress" value="">
                                    <%--<ul id="imageUl" class="ace-thumbnails clearfix hidden"--%>
                                        <%--style=" display: inline-block;">--%>
                                        <%--<li>--%>
                                            <%--<a data-rel="colorbox">--%>
                                                <%--<img width="150" id="icon-img" alt="150x150" data-path="" src=""/>--%>
                                                <%--<div class="tools tools-top">--%>
                                                    <%--<a class="delPic"> <i class="ace-icon fa fa-times red">删除</i>--%>
                                                    <%--</a></div>--%>
                                            <%--</a>--%>
                                        <%--</li>--%>
                                    <%--</ul>--%>
                                    <%--<input type="hidden" id="fileAddress" name="fileAddress" value="">--%>
                                    <%--<a href="#modal-import" class="btn btn-white btn-primary" data-toggle="modal"--%>
                                       <%--style="position: absolute;top: 2px;">--%>
                                        <%--<i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择文件--%>
                                    <%--</a>--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">说明：</label>
                                <div class="col-sm-9">
                                    <script id="remarks" name="remarks"
                                            type="text/plain"></script>
                                    <label id="remarkTip"></label>
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



<%-- import pop--%>
<div id="modal-import" class="modal fade" tabindex="-21" style="margin-top: 20px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    版本检查项
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <div class="form-group">
                                <div class="col-xs-12" style="margin-bottom: 10px">
                                    <span>请选择APK文件：</span>
                                    <%--<a href="${staticServer}/upload/model/lwgk-批量发货模板.xls">lwgk-批量发货模板.xls</a>--%>
                                </div>
                            </div>
                            <c:url value="${uploadServer}/common/upload.do"
                                   var="import_url"/>
                            <form:form action="${import_url}"
                                       enctype="multipart/form-data" method="post" id="upload-form">
                                <input type="hidden" name="file_type" value="version">

                                <div class="form-group">
                                    <%--<div class="col-xs-12">--%>
                                        <%--<input name="file" type="file" id="icon-input" class="uploadifive" accept=".apk"/>--%>
                                    <%--</div>--%>
                                    <%--<div id="tip-queue"></div>--%>
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

<%--文件上传结果--%>
<div id="import-result-modal" class="modal fade" tabindex="-21" style="margin-top: 20px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    文件上传结果
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
                                            <%--<button class="btn btn-white btn-primary" type="button" id="result-index">--%>
                                            <%--<i class="ace-icon fa fa-check bigger-110"></i> 回到代金券首页--%>
                                            <%--</button>--%>
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
<script src="${staticServer }/assets/js/jquery.validation/additional-methods.js"></script>

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
<script src="${staticServer}/assets/js/jquery.uploadifive.js"></script>
<script>

    $(function () {
        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwInvitation");

        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.versionNo = $("#NameSearch").val();

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
                    url: '${dynamicServer}/cms/version/getList.do',//请求数据的参数
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
                    data: "id",
                    render: function (data) {
                        return data || "";
                    }
                },{
                    data: "versionNo",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "fileAddress",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "id",
                    width: "285px",
                    render: function (data, type, row) {
                        var button="";
//                        button+= '<a class="btn btn-sm btn-success" ' +
//                            'onclick="goVoucherLogById(\'' + data + '\')">' +
//                            '<i class="ace-icon fa fa-pencil-square-o "></i>下载</a>';
                            button += '&nbsp;&nbsp;' +
                                '<a class="btn btn-sm btn-danger" onclick="delInvitation(\'' + data + '\')">' +
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

        UE.getEditor('remarks', {
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

        /*日期*/
        var date = dateFormatHour(new Date());
        $(".datetimepicker").val(date);

        $.fn.datetimepicker.dates['zh'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
            meridiem: ["上午", "下午"],
            today: "今天"
        };

        $('#startDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#endDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
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
                versionNo: {
                    required: true,
                },
                fileAddress: {
                    required: true,
                },
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

    });


//    $('#lwInvitationForm').submit(function() {
//        $(this).ajaxSubmit({
//            success: function (data) {
//                alert(data.message);
//                $('#modal-edit').modal('hide');
//                table.draw();
//            }
//        });
//        return false;
//    });


    $("#result-btn").on('click', function () {
        $("#import-result-modal").modal("hide");
    });


    /*新增时清空表单数据*/
    function flushForm() {

        /*设置图层*/


        $(".modal").css("z-index", "4");
        $("div.modal-backdrop").attr("z-index", "3");
//        $(".edui-dialog").css("z-index", "1060");


        //        清空活动图片数据
        $("#imageUl").addClass("hidden");
        $("[name=actPhoto]").val('');
        $("#icon-img").attr("src", "");

        //        清空活动图片上传file文件
        $("#icon-input").val('');

    }



    /*作废/恢复*/
    function cancelVoucher(id,state) {
        var altStr;
        if(state!=2){
            altStr=("确定要恢复该代金券？");
        }else{
            altStr=("确定要作废该代金券？");
        }
        bootbox.confirm("<a style='font-size: 17px;color: red'>"+altStr+"</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/voucher/cancelVoucher.do",
                    data: {
                        "id": id,
                        "state":state
                    },
                    contentType: 'application/json',
                    success: function (data) {
                        if(data.success){
                            alert(data.message);
                        }else{
                            alert(data.message);
                        }
                        table.draw();
                    }
                });
            }
        });
    }

    function addLwCourse() {
        window.location.href = "${dynamicServer}/cms/voucher/toAdd.do";
    }
    function goVoucherLogById(id) {
        window.location.href = "${dynamicServer}/cms/voucherLog/index.do?id="+id;
    }
    <%--function updateLwCourse(id) {--%>
    <%--window.location.href = "${dynamicServer}/cms/voucher/toUpdate.do?id=" + id + "&type=" +${type};--%>
    <%--}--%>

    var $option;
    /*修改时需要回显数据*/
    function updateInvitation(id) {
        flushForm();
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/cms/version/findOne.do",
            data: {
                "id": id
            },
            contentType: 'application/json',
            success: function (data) {
                for (var key in data) {
                    $("#" + key).val(data[key]);
                    if(key=="lwCourseList"){
//                        alert(data[key]);
                        if(data[key]==null){
                            $("#courseType").val(2);
                            $("#courseNo").parent().parent().hide();
                        }else{
                            $lwCourseIds.empty();
                            for(var list in data[key]){
//                            $lwCourseIds.append("<option selected value='"+data[key][list]['id']+"'>"+data[key][list]['name']+"</option>");
                                var $option = $('<option selected></option>').val(data[key][list]['id']).text(data[key][list]['name']);
                                $lwCourseIds.append($option);

                            }
                            $lwCourseIds.trigger('change');
                        }

                    }

                    if(key=="actPhoto"&&data[key]!=null&&data[key]!=""){
                        var img_path = data[key];
                        var img_url = '${imageServer}' + img_path;
                        var $shareUrl_img = $("#icon-img");
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#imageUl").removeClass("hidden");
                    }
                    if(key=="sharePhoto"&&data[key]!=null&&data[key]!=""){
                        var img_path = data[key];
                        var img_url = '${imageServer}' + img_path;
                        var $shareUrl_img = $("#shareUrl-img");
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#shareUrlUl").removeClass("hidden");
                    }

                    flushByType();
                }

            }
        });
    }

    /*删除*/
    function delInvitation(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该版本信息？</a>", function (result) {

                                if (result) {
                                    $.ajax({
                                        type: "GET",
                                        url: "${dynamicServer}/cms/version/delete.do",
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


    var $import_input = $('#icon-input');

//    $import_input.ace_file_input({
//        style: 'well',
//        btn_choose: '点击选择apk文件',
//        btn_change: null,
//        no_icon: 'ace-icon fa fa-file-excel-o',
//        droppable: false,
//        thumbnail: 'small',//large | fit
//        maxSize: 1024000000,
//        allowExt: ['apk'],
////        allowMime: ['application/vnd.ms-excel', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'],
//        before_remove: function () {
//            return true;
//        }
//
//    }).on('change', function () {
//        if ($import_input.val() == '') {
////            resetFileinput();
//            return false;
//        }
//    }).on('file.error.ace', function (ev, info) {
//        if (info.error_count['ext']) {      // || info.error_count['mime']
//            $.notify("请选择Excel文件!");
//            return false;
//        }
//        if (info.error_count['size']) {
//            $.notify("文件不超过100M!");
//            return false;
//        }
//    });

    $('.uploadifive').uploadifive({
//        'auto' : false,   //取消自动上传
        'width'         : '80px',   //按钮宽度
        'height'        : '20px',   //按钮高度
//        'removeCompleted' : true,   //上传成功后自动隐藏列表
        'multi'         : false,
        'fileSizeLimit' : '100MB',
        'queueSizeLimit'    : 1,
        'uploadScript' : '${uploadServer}/common/upload.do',  //处理上传文件Action路径
        'fileObjName' : 'file',        //文件对象
        'buttonText'   : '选择文件',   //按钮显示文字
        'queueID'      : 'tip-queue', //提示信息放置目标
//        'fileType'     : '*',   //允许上传文件类型
//        'onAddQueueItem' : function(file){
//            this.data('uploadifive').settings.formData = {'id':$(this).data('id')};    //传递动态参数方法
//        },
        'onUploadComplete' : function(file, data) { //文件上传成功后执行
            $("#fileAddress").val(JSON.parse(data).createFilePath);
//            alert('The file ' + file.name + ' uploaded successfully.'+JSON.parse(data).createFilePath);
        },
        onCancel : function(file){
            $data    = $(this).data('uploadifive'),
                settings = $data.settings;
            settings.uploadLimit++;
            layer.msg(file.name + " 已取消上传~",{icon:2});
        },
    });

    var subject_upload_form = $("#upload-form");
    //导入提交
    subject_upload_form.on('submit', function () {
        var upload_check = $import_input.val();
        if (upload_check == '') {
//            resetFileinput();
            $.notify("请选择文件!");
            return false;
        }
        $import_input.ace_file_input('loading', true);
        $(".ace-file-overlay").append('<div class="overlay-text">正在导入中...</div>');



//        subject_upload_form.ajaxSubmit({
//            type: 'post', // 提交方式 get/post
//            url: subject_upload_form.attr('action'),
//            dataType: 'json',
//            success: function (result) {
//                $import_input.ace_file_input('loading', false);
//                var msg = '';
//                if (result && result.success) {
//                    $("#modal-import").modal("hide");  //关闭上传窗口
//                    $import_input.val('');
////                    resetFileinput();
//                    msg = result.message;
//
//                    $("#fileAddress").val(result.createFilePath);
//
//                    $("#result-text").html(msg);
//                    $("#import-result-modal").modal("show");
////
//                    //$.notify(msg);
//                } else {
//                    $("#modal-import").modal("hide");   //关闭上传窗口
//                    $import_input.val('');
//                    resetFileinput();
//                    $import_input.ace_file_input('loading', false);
//                }
//            }
//        });
        return false;
    });
    $("#result-btn").on('click', function () {
        $("#import-result-modal").modal("hide");
        table.draw();
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


