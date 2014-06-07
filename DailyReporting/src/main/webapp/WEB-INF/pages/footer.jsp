<!-- <div id="footer">
	<div class="wrapper">
		
		<p id="copyright">
			This confidential information should not be distributed without prior written consent and should only be used to review health care utilization.
		</p>
	</div>
</div> -->

<script type="text/javascript">
$(document).ready(function() {
    $('#updateMonths').click(function(event) {
        /* Act on the event */
         CII.updateReportSelection(); 
         console.log('from the page'+CII.yearMonths );
   });
});
$(document).ready(function () {
    CII = {
        yearMonths: [],
        duplicates: [],
        updateReportSelection: function () {
            CII.yearMonths = $(".multiSel-hidden").text()
        },
        checkDuplicateAccounts: function () {
            $(".access-allowed-accounts").is(":visible")
        }
    }, $("nav.primary-nav").find("li.parent").hover(function () {
        $(".subnav").css("z-index", "0"), $(this).children(".subnav").show().css("z-index", "100")
    }, function () {
        $(this).not(".active").children(".subnav").hide()
    }), $(".accordion h3.expand").click(function (a) {
        "select-all task-button" === a.target.className ? $(a.target).parent().next(".tabular").find("input[type=checkbox]").prop("checked", !0) : ($(this).children("div.icon").hasClass("icon-slideup") ? $(this).children("div.icon").removeClass("icon-slideup").addClass("icon-slidedown") : $(this).children("div.icon").removeClass("icon-slidedown").addClass("icon-slideup"), $(this).next(".collapse").slideToggle("fast"))
    }), $(".expand-all").click(function () {
        $(this).parent().parent().next(".accordion").find("h3.expand").children("div.icon").addClass("icon-slidedown").removeClass("icon-slideup"), $(this).parent().parent().next(".accordion").find("h3.expand").next(".collapse").slideDown("fast")
    }), $(".collapse-all").click(function () {
        $(this).parent().parent().next(".accordion").find("h3.expand").children("div.icon").addClass("icon-slideup").removeClass("icon-slidedown"), $(this).parent().parent().next(".accordion").find("h3.expand").next(".collapse").slideUp("fast")
    }), $("li.dropdown").hover(function () {
        $(this).children(".dropdown-container").slideDown("fast")
    }, function () {
        $(this).children(".dropdown-container").hide()
    }), $("li.dropdown").children("a").click(function (a) {
        a.preventDefault()
    }), $("tr").find(".icon-slidedown").hide(), $(".icon-slideup").not(".icon, .topH").click(function () {
        $(this).hide().siblings(".desc").slideDown().siblings(".icon-slidedown").show()
    }), $(".icon-slidedown").not(".icon, .topH").click(function () {
        $(this).hide().siblings(".desc").slideUp().siblings(".icon-slideup").show()
    }), $("th, td").iWouldLikeToAbsolutelyPositionThingsInsideOfFrickingTableCellsPlease(), $(".dropdown-select dt a").on("click", function (a) {
        a.preventDefault(), $(".dropdown-select dd .months-container").slideToggle("fast")
    }), $("#updateMonths, .dropdown-select .cancel").on("click", function () {
        $(".dropdown-select dd .months-container").hide()
    }), $(document).bind("click", function (a) {
        var b = $(a.target);
        b.parents().hasClass("dropdown-select") || $(".dropdown-select dd .months-container").hide(), b.parents().hasClass("segment-dropdown") || $(".segment-dropdown dd.segment-list").hide()
    }), $('.mutliSelect input[type="checkbox"]').on("click", function () {
        var a = $(this).closest(".mutliSelect").find('input[type="checkbox"]').val(),
            a = $(this).val() + ",";
        if ($(this).is(":checked")) {
            var b = '<span title="' + a + '">' + a + "</span>";
            $(".multiSel-hidden").append(b)
        } else $('span[title="' + a + '"]').remove()
    }), $(".segment-dropdown").find(".trigger").on("click", function (a) {
        a.preventDefault(), $(".segment-list").show()
    }), $(".segment-list").find("li a").on("click", function (a) {
        a.preventDefault(), $(".segment-list").hide(), $(".segment-dropdown").find(".selection").html($(this).text())
    }), $("#viewAllSegments") && $("#viewAllSegments").find("a").on("click", function () {
        $(".segment-dropdown").find(".selection").html($(this).text())
    }), $("#sortable").sortable(), $("#sortable").disableSelection(), $("#allaccNo").on("change", function (a) {
        a.preventDefault(), $(this).is(":checked") && $(".add-account-link").show()
    }), $("#allaccYes").is(":checked") ? $(".add-account-link").hide() : $(".add-account-link").show(), $("#allaccYes").on("change", function (a) {
        a.preventDefault(), $(this).is(":checked") && $(".add-account-link").hide()
    }), $(".allaccmNo").on("change", function (a) {
        a.preventDefault(), $(this).is(":checked") && $(this).parent().parent().parent().parent().find(".add-account-link").show()
    }), $(".allaccmYes:checked").parent().parent().parent().parent().find(".add-account-link").hide(), $(".allaccmNo:checked").parent().parent().parent().parent().find(".add-account-link").show(), $(".allaccmYes").on("change", function (a) {
        a.preventDefault(), $(this).is(":checked") && $(this).parent().parent().parent().parent().find(".add-account-link").hide()
    }), $(".edit-icon").on("click", function (a) {
        a.preventDefault(), $(this).parents("tr").next(".edit-content-row").show()
    }), $(".edit-content-row").find(".cancel-button").click(function () {
        $(this).parents(".edit-content-row").hide()
    }), $(".add-edit-accounts").click(function (a) {
        a.preventDefault();
        var b = $(this).siblings("ul.access-allowed-accounts").data("element-name");
        b && ($("#addEditAccouts").removeData(), $("#addEditAccouts").data("trigger-element", b)), $("#addEditAccouts").modal()
    }), $("#addEditAccouts").not("#addEditAccouts.external_user_with_segment").find(".add-account-modal-button").click(function () {
        var a = [],
            b = [],
            c = $(this).parent().parent().data("trigger-element"),
            d = [];
        $(".access-allowed-accounts[data-element-name=" + c + "]").find("label").each(function (a) {
            d[a] = $(this).text()
        }), $(this).parent().find("input[type=checkbox]:checked").each(function (b) {
            a[b] = $(this).parent().parent().next().text()
        }), d.length && $.each(a, function (c, e) {
            -1 !== $.inArray(e, d) && (b.push(e), a = $.grep(a, function (a) {
                return a != e
            }))
        }), c && $.each(a, function (a, b) {
            $(".access-allowed-accounts[data-element-name=" + c + "]").append('<li class="removable">\n                                        <div class="fl">\n                                            <label for="1as" class="fl">' + b + '</label>\n                                        </div>\n                                        <div class=" fr"> <span class="remove-row">x</span> </div>\n                                    </li>')
        })
    }), $("#addEditAccouts.external_user_with_segment").find(".add-account-modal-button").click(function () {
        var a = {
                account_name: [],
                segment_name: []
            },
            b = [],
            c = [],
            d = $(this).parent().parent().data("trigger-element"),
            e = {
                account_name: [],
                segment_name: []
            };
        $(".access-allowed-accounts[data-element-name=" + d + "]").find("label.account_details").each(function (a) {
            e.account_name[a] = $(this).find(".account_name").text(), e.segment_name[a] = $(this).find(".segment_name").text()
        }), $(this).parent().find("input[type=checkbox]:checked").each(function (b) {
            a.account_name[b] = $(this).parent().parent().next().text(), a.segment_name[b] = $(this).parent().parent().next().next().text()
        }), $.each(a.account_name, function (c) {
            b += "\n" + a.account_name[c] + "(" + a.segment_name[c] + ")"
        }), $.each(e.account_name, function (a) {
            c += "\n" + e.account_name[a] + "(" + e.segment_name[a] + ")"
        }), d && $.each(a.account_name, function (b) {
            $(".access-allowed-accounts[data-element-name=" + d + "]").append('<li class="removable">\n                                <div class="fl">\n                                    <!-- <input type="checkbox" name="" id="1as" checked="checked"> -->\n                                    <label for="1as" class="fl account_details">\n                                        <span class="account_name">' + a.account_name[b] + '</span>\n                                        (<span class="segment_name">' + a.segment_name[b] + '</span>) &nbsp;\n                                    </label>\n                                    <input type="checkbox" name="" id="2as">\n                                    <label for="2as" class="fl">PHI</label>\n                                </div>\n                                <div class=" fr">\n                                    <span class="remove-row">x</span>\n                                </div>\n                            </li>')
        })
    }), $(document.body).on("click", ".removable .remove-row", function () {
        $(this).parent().parent().remove()
    }), $(".removable-file").find(".remove-row").on("click", function (a) {
        a.preventDefault(), confirm("Sure to permanently remove this file?") && ($(this).parent().parent().remove(), $(".new-file").show())
    }), $(".delete-announcement").click(function () {
        if (confirm("Sure to permanently remove this announcement?")) {
            var a = $(this).parents(".edit-content-row"),
                b = a.prev("tr");
            a.remove(), b.remove()
        }
    })
}), $.fn.iWouldLikeToAbsolutelyPositionThingsInsideOfFrickingTableCellsPlease = function () {
    var a;
    return this.each(function () {
        a = $(this);
        var b = $("<div />", {
            "class": "innerWrapper",
            css: {
                width: "100%",
                position: "relative"
            }
        });
        a.wrapInner(b)
    })
}, $(document).ready(function () {
    $(".add.report-category-title").on("click", function (a) {
        a.preventDefault(), $(this).next(".addRC-section").show()
    }), $(".edit-report-category").on("click", function (a) {
        a.preventDefault(), $(this).parent().parent().next(".addRC-section").show()
    }), $(".reports-list").find(".edit-report").on("click", function (a) {
        a.preventDefault(), $("#editReport").find(".report-name").val($(this).parent().find(".report-title").text()), $("#editReport").modal()
    }), $(".addRC-section").find(".cancel").click(function () {
        $(this).parents(".addRC-section").hide()
    }), $(".reports-list").sortable({
        connectWith: ".reports-list"
    }).tooltip({
        position: {
            my: "left+115 top-10"
        }
    }), $(".report-selection-parent").find("input.parent").click(function () {
        $(this).is(":checked") ? $(this).parent("h3").next(".report-selection-child").find("input[type=checkbox]").prop("checked", !0) : $(this).parent("h3").next(".report-selection-child").find("input[type=checkbox]").removeAttr("checked")
    })
});
</script>
<div class="cb"></div>
<footer>Copyright © 2008 Gotan Stone Lime Industries. All rights reserved.</footer>
