<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-
        订单修改页</title>
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
                        订单修改页
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${dynamicServer}/cms/order/save.do" method="post">
                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12"> 订单<c:if test="${check!=1}">修改</c:if>页 </span><!-- /.col -->
                                </h3>
                            </div>

                            <input type="hidden" value="${lwOrder.orderNumber}" id="orderNumber" name="orderNumber"/>
                            <input type="hidden" value="${lwOrder.orderShow}" id="orderShow" name="orderShow"/>
                            <input type="hidden" value="${lwOrder.userNo}" id="userNo" name="userNo"/>
                            <input type="hidden" value="${lwOrder.orderAmount}" id="orderAmount" name="orderAmount"/>
                            <input type="hidden" value="${lwOrder.freight}" id="freight" name="freight"/>
                            <input type="hidden" value="${lwOrder.isIntegral}" id="isIntegral" name="isIntegral"/>
                            <input type="hidden" value="${lwOrder.integralValue}" id="integralValue" name="integralValue"/>
                            <input type="hidden" value="${lwOrder.isVouchers}" id="isVouchers" name="isVouchers"/>
                            <input type="hidden" value="${lwOrder.vouchersValue}" id="vouchersValue" name="vouchersValue"/>
                            <input type="hidden" value="${lwOrder.remark}" id="remark" name="remark"/>
                            <input type="hidden" value="${lwOrder.city}" id="city" name="city"/>
                            <input type="hidden" value="${lwOrder.province}" id="province" name="province"/>
                            <input type="hidden" value="${lwOrder.zipCode}" id="zipCode" name="zipCode"/>
                            <input type="hidden" value="${lwOrder.payDate}" id="payDate" name="payDate"/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">订单号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="externalNo" name="externalNo" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.externalNo}" readonly>
                                    <label id="externalNoTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">资料名称：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="goodsName" name="goodsName" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.goodsName}" required <c:if test="${check==1}">readonly</c:if>>
                                    <label id="goodsNameTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="userName" name="userName" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.userName}" required <c:if test="${check==1}">readonly</c:if>>
                                    <label id="userNameTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">手机：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="phone" name="phone" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.phone}" required <c:if test="${check==1}">readonly</c:if>>
                                    <label id="phoneTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">地址：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="address" name="address" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.address}" required <c:if test="${check==1}">readonly</c:if>>
                                    <label id="addressTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">费用：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="finalAmount" name="finalAmount" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.finalAmount}" readonly <c:if test="${check==1}">readonly</c:if>>
                                    <label id="finalAmountTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">类型：</label>
                                <div class="col-sm-9">
                                    <select name="type" id="type" class="col-sm-12 col-lg-7" title="">
                                        <c:if test="${lwOrder.type==1}"><option value="1" selected>课程</option></c:if>
                                    </select>
                                    <label id="typeTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-9">
                                    <select name="status" id="status" class="col-sm-12 col-lg-7" title="">
                                        <c:if test="${lwOrder.status==0}"><option value="0" selected>已创建待付款</option></c:if>
                                        <c:if test="${lwOrder.status==1}"><option value="1" selected>已付款待发货</option></c:if>
                                        <c:if test="${lwOrder.status==2}"><option value="2" selected>已发货</option></c:if>
                                    </select>
                                    <label id="statusTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">快递公司：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="deliveryCompany" name="deliveryCompany" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.deliveryCompany}" required <c:if test="${check==1}">readonly</c:if>>
                                    <label id="deliveryCompanyTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">快递单号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="deliveryNumber" name="deliveryNumber" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${lwOrder.deliveryNumber}" required <c:if test="${check==1}">readonly</c:if>>
                                    <label id="deliveryNumberTip"></label>
                                </div>
                            </div>

                            <c:if test="${check!=1}">
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
                            </c:if>
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

<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>

<%--<script src="${staticServer}/assets/ueditor1.4.3/lang/zh-cn/zh-cn.js"></script>--%>
<script src="${staticServer}/assets/js/jquery.form.js"></script>
<script src="${staticServer}/assets/components/fuelux/js/spinbox.js"></script>
<script src="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
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



        if ($('#dispatcheObj').val() == null || $('#dispatcheObj').val() == 0) {
            $("#courseNo").parent().parent().hide();
            $("#voucherNo").parent().parent().hide();
            $("#url").parent().parent().hide();
        } else if ($('#dispatcheObj').val() == 1) {
            $("#courseNo").parent().parent().show();
            $("#voucherNo").parent().parent().hide();
            $("#url").parent().parent().hide();
            $("#appurl").parent().parent().hide();
        } else if($('#dispatcheObj').val() == 2)  {
            $("#courseNo").parent().parent().hide();
            $("#voucherNo").parent().parent().show();
            $("#url").parent().parent().hide();
            $("#appurl").parent().parent().hide();
        }else if($('#dispatcheObj').val() == null ){
            $("#courseNo").parent().parent().hide();
            $("#voucherNo").parent().parent().hide();
        }else{
            $("#courseNo").parent().parent().hide();
            $("#voucherNo").parent().parent().hide();
            $("#url").parent().parent().show();
            $("#appurl").parent().parent().show();
        }
        /*选择发放对象*/
        $("#dispatcheObj").on('change', function () {
            switch($("#dispatcheObj").val()){
                case '0':
                    $("#courseNo").parent().parent().hide();
                    $("#voucherNo").parent().parent().hide();
                    $("#url").parent().parent().hide();
                    break;
                case '1':
                    $("#courseNo").parent().parent().show();
                    $("#voucherNo").parent().parent().hide();
                    $("#url").parent().parent().hide();
                    $("#appurl").parent().parent().hide();
                    break;
                case '2':
                    $("#courseNo").parent().parent().hide();
                    $("#voucherNo").parent().parent().show();
                    $("#url").parent().parent().hide();
                    $("#appurl").parent().parent().hide();
                    break;
                case '3':
                    $("#courseNo").parent().parent().hide();
                    $("#voucherNo").parent().parent().hide();
                    $("#url").parent().parent().show();
                    $("#appurl").parent().parent().show();
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
                nickName: {
                    required: true,
                    maxlength: 20
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
        window.location.href = "${dynamicServer}/cms/order/index.do";
    }
</script>
</body>
</html>
