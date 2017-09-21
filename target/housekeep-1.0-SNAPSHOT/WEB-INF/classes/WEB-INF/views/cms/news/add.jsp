<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-
        消息添加</title>
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
                      消息添加
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${dynamicServer}/cms/news/save.do" method="post">
                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12"> 添加消息 </span><!-- /.col -->
                                </h3>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Icon类型：</label>
                                <div class="col-sm-9">
                                    <select name="iconId" id="iconId" class="col-sm-12 col-lg-7" title="">
                                        <option value="1" selected>系</option>
                                        <option value="2">订</option>
                                        <option value="3">课</option>
                                        <option value="4">邮</option>
                                        <option value="5">福</option>

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">标题：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="header" name="header" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="">

                                    <label id="headerTip"></label>
                                </div>

                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">内容：</label>
                                <div class="col-sm-9">
                                    <textarea id="contents" name="contents" class="col-xs-12 col-sm-7" rows="5"
                                              placeholder="请输入消息内容..."
                                              maxlength="500"></textarea>

                                    <label id="contentsTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-9">
                                    <select name="state" id="state" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected">未审核</option>
                                        <option value="1">已审核</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">发放对象：</label>
                                <div class="col-sm-9">
                                    <select name="dispatcheObj" id="dispatcheObj" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected">部分用户</option>
                                        <option value="1">课程用户</option>
                                        <option value="2">全站用户</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">选择课程：</label>
                                <div class="col-sm-9">
                                    <select id="courseNo" name="courseNo"
                                            class="col-xs-12 col-sm-7 col-lg-7" style="width: 58.5%"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">发放对象：</label>
                                <div class="col-sm-9">
                                    <textarea id="telephone" name="telephone" class="col-xs-12 col-sm-7" rows="5" maxlength="500"></textarea>
                                    <label id="telephoneTip"></label>
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
                                <input type="hidden" name="file_type" value="icon">
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

<!-- /.main-container -->
<%@ include file="../../common/js.jsp" %>

<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>

<script src="${staticServer}/assets/js/jquery.form.js"></script>
<script src="${staticServer}/assets/select2/select-topic-tags.js"></script>
<script src="${staticServer}/assets/select2/select2.full.js"></script>
<script type="text/javascript">
    var $lwCourseIds = $('#courseNo');
    var $lwVoucherIds = $('#voucherNo');
        $(function () {
            /*下拉选择课程*/
            $lwCourseIds.select2({
                tags: true,
//            multiple: true,
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
                    url: "${dynamicServer}/cms/course/getListByName.do",
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
                    return course.name|| course.text;
                },
                templateSelection: function (course) {
                    return course.name|| course.text;
                }
            });
            /*下拉选择课程*/
            $lwVoucherIds.select2({
                tags: true,
//            multiple: true,
                createTag: function (params) {
                    console.log(arguments);
                    return null;
                },
                placeholder: '请输入要关联的代金券',
                language: {
                    noResults: function () {
                        return '没有找到该代金券';
                    },
                    inputTooShort: function () {
                        return '请至少输入1个字符';
                    }
                },
                ajax: {
                    url: "${dynamicServer}/cms/voucher/getListByName.do",
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
                    return course.name|| course.text;
                },
                templateSelection: function (course) {
                    return course.name|| course.text;
                }
            });

            if ( $('#dispatcheObj').val() == 0) {
                $("#courseNo").parent().parent().hide();
                $("#telephone").parent().parent().show();
            } else if ($('#dispatcheObj').val() == 1) {
                $("#courseNo").parent().parent().show();
                $("#telephone").parent().parent().hide();
            }else{
                $("#courseNo").parent().parent().hide();
                $("#telephone").parent().parent().hide();
            }
            /*选择发放对象*/
            $("#dispatcheObj").on('change', function () {
                switch($("#dispatcheObj").val()){
                    case '0':
                        $("#courseNo").parent().parent().hide();
                        $("#telephone").parent().parent().show();
                        break;
                    case '1':
                        $("#courseNo").parent().parent().show();
                        $("#telephone").parent().parent().hide();

                        break;
                    case '2':
                        $("#courseNo").parent().parent().hide();
                        $("#telephone").parent().parent().hide();

                        break;

                    default:

                }

            });
        $("#infoForm").validate({
            errorElement: "label",
            errorClass: "valiError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                header: {
                    required: true,
                },
                contents: {
                    required: true,
                },

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
                        $("[name=imgUrl]").val(img_path);
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
                        $("[name=icon]").val('');
                        $("#icon-img").attr("src", "");
                    } else {
                        $.notify({message: "文件路径错误!", z_index: 15111});
                    }
                }
            })
        });


    });
    function backIndex() {
        window.location.href = "${dynamicServer}/cms/startupPage/index.do";
    };

</script>
</body>
</html>
