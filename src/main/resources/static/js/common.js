var jieqiUserId = 0;
var jieqiUserName = '';
var jieqiUserPassword = '';
var jieqiUserGroup = 0;
var jieqiNewMessage = 0;
var jieqiUserVip = 0;
var jieqiUserHonor = '';
var jieqiUserGroupName = '';
var jieqiUserVipName = '';

// function get_cookie_value(Name) {
//     var search = Name + "=";
//     var returnvalue = "";
//     if (document.cookie.length > 0) {
//         offset = document.cookie.indexOf(search)
//         if (offset != -1) {
//             offset += search.length
//             end = document.cookie.indexOf(";", offset);
//             if (end == -1)
//                 end = document.cookie.length;
//             returnvalue = unescape(document.cookie.substring(offset, end));
//         }
//     }
//     return returnvalue;
// }

if (document.cookie.indexOf('jieqiUserInfo') >= 0) {
    var jieqiUserInfo = get_cookie_value('jieqiUserInfo');
    //document.write(jieqiUserInfo);
    start = 0;
    offset = jieqiUserInfo.indexOf(',', start);
    while (offset > 0) {
        tmpval = jieqiUserInfo.substring(start, offset);
        tmpidx = tmpval.indexOf('=');
        if (tmpidx > 0) {
            tmpname = tmpval.substring(0, tmpidx);
            tmpval = tmpval.substring(tmpidx + 1, tmpval.length);
            if (tmpname == 'jieqiUserId') jieqiUserId = tmpval;
            else if (tmpname == 'jieqiUserName_un') jieqiUserName = tmpval;
            else if (tmpname == 'jieqiUserPassword') jieqiUserPassword = tmpval;
            else if (tmpname == 'jieqiUserGroup') jieqiUserGroup = tmpval;
            else if (tmpname == 'jieqiNewMessage') jieqiNewMessage = tmpval;
            else if (tmpname == 'jieqiUserVip') jieqiUserVip = tmpval;
            else if (tmpname == 'jieqiUserHonor_un') jieqiUserHonor = tmpval;
            else if (tmpname == 'jieqiUserGroupName_un') jieqiUserGroupName = tmpval;
        }
        start = offset + 1;
        if (offset < jieqiUserInfo.length) {
            offset = jieqiUserInfo.indexOf(',', start);
            if (offset == -1) offset = jieqiUserInfo.length;
        } else {
            offset = -1;
        }
    }
}

//?????????
function getNames(obj, name, tij) {
    var p = document.getElementById(obj);
    var plist = p.getElementsByTagName(tij);
    var rlist = new Array();
    for (i = 0; i < plist.length; i++) {
        if (plist[i].getAttribute("name") == name) {
            rlist[rlist.length] = plist[i];
        }
    }
    return rlist;
}

function fod(obj, name) {
    var p = obj.parentNode.getElementsByTagName("td");
    var p1 = getNames(name, "f", "div");
    // document.getElementById(name).getElementsByTagName("div");

    for (i = 0; i < p1.length; i++) {
        if (obj == p[i]) {
            p[i].className = "tab" + i + "1";
            ;
            p1[i].className = "dis";
        }
        else {
            p[i].className = "tab" + i + "0";
            p1[i].className = "undis";
        }
    }
}

//???????????????
// function addvisit(bid) {
//     url = "/modules/article/articlevisit.php?id=" + bid;
//     $.get(url);
// }

// ???????????????????????????
// function showpop(url) {
//     $.get(url, function (data) {
//         alert(data.replace(/<br[^<>]*>/g, '\n'));
//     });
// }

// ??????????????????
// function addBookmark(title, url) {
//     if (!title) {
//         title = document.title
//     }
//     if (!url) {
//         url = window.location.href
//     }
//     if (window.sidebar) {
//         window.sidebar.addPanel(title, url, "");
//     } else if (document.all) {
//         window.external.AddFavorite(url, title);
//     } else if (window.opera || window.print) {
//         alert('??????????????????????????????Ctrl + D ?????????');
//         return true;
//     }
// }

function Login() {
    if (jieqiUserId != 0 && jieqiUserName != '' && (document.cookie.indexOf('PHPSESSID') != -1 || jieqiUserPassword != '')) {
        document.write('Hi,<a href="/userdetail.php" target="_top">' + jieqiUserName + '</a> | <a href="/logout.php" target="_self">????????????</a>');
    } else {
        document.writeln("<a href=\"/login.php\">??????</a>???<a href=\"/register.php\">??????</a>");
    }
    document.writeln("<br><a target=\"_blank\" class='red' href=\"https://m.xbiquge.so/\">????????????</a>");
}

// ??????????????????
function foot() {
    document.writeln("<p>????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</p>");
    // document.writeln("<p>Copyright &copy; " + new Date().getFullYear() + " <a href=\"https://www.xbiquge.so\">?????????</a>(www.xbiquge.so)  All Rights Reserved.</p>");
};

// ??????JS
function loadJs(url) {
    if (arguments.length >= 2 && typeof arguments[1] == 'function') funload = arguments[1];
    if (arguments.length >= 3 && typeof arguments[2] == 'function') funerror = arguments[2];
    var ss = document.getElementsByTagName("script");
    for (i = 0; i < ss.length; i++) {
        if (ss[i].src && ss[i].src.indexOf(url) != -1) {
            if (typeof funload == "function") funload();
            return;
        }
    }
    s = document.createElement("script");
    s.type = "text/javascript";
    s.defer = "defer";
    s.src = url;
    document.getElementsByTagName("head")[0].appendChild(s);

    s.onload = s.onreadystatechange = function () {
        if (this.readyState && this.readyState == "loading") return;
        if (typeof funload == "function") funload();
    }
    s.onerror = function () {
        this.parentNode.removeChild(this);
        if (typeof funerror == "function") funerror();
    }
}

// ???????????????????????????????????????????????????
function ReadOptions() {
    document.writeln("?????????<select onChange=\"changebgcolor(this)\" id=\"bcolor\" name=\"bcolor\"><option value=\"#FAF7ED\" style=\"background-color: #E9FAFF;\">????????????</option><option value=\"#E9FAFF\" style=\"background-color: #E9FAFF;\">????????????</option><option value=\"#FFFFED\" style=\"background-color: #FFFFED;\">????????????</option><option value=\"#EEFAEE\" style=\"background-color: #EEFAEE;\">????????????</option><option value=\"#FCEFFF\" style=\"background-color: #FCEFFF;\">????????????</option><option value=\"#FFFFFF\" style=\"background-color: #FFFFFF;\">????????????</option><option value=\"#EFEFEF\" style=\"background-color: #EFEFEF;\">????????????</option></select>");
    document.writeln("?????????<select  onchange=\"changecolor(this)\" id=\"txtcolor\" name=\"txtcolor\"><option value=\"#555555\" style=\"color: #555555;\">??????</option><option value=\"#000000\" style=\"color: #000000;\">??????</option><option value=\"#ff0000\" style=\"color: #FF0000;\">??????</option><option value=\"#006600\" style=\"color: #006600;\">??????</option><option value=\"#0000ff\" style=\"color: #0000FF;\">??????</option><option value=\"#660000\" style=\"color: #660000;\">??????</option></select>");
    document.writeln("?????????<select onChange=\"changesize(this)\" id=\"fonttype\" name=\"fonttype\"><option value=\"20px\" selected=\"selected\">??????</option><option value=\"12px\">??????</option><option value=\"15px\">??????</option><option value=\"18px\">??????</option><option value=\"20px\">??????</option><option value=\"24px\">??????</option></select>");
    document.writeln("???????????????<select onChange=\"setSpeed(this)\" id=\"scrollspeed\" name=\"scrollspeed\"><option value=\"1\">??????</option><option value=\"3\">??????</option><option value=\"5\" selected=\"selected\">??????</option><option value=\"7\">??????</option><option value=\"10\">??????</option></select>");
}

// // ?????????????????????
// function readtip() {
//     document.writeln("<p style=\"color:#B2B2B2;font-size: 12px;padding:10px 0;text-align: center;\">??????????????? Ctrl+D ????????????????????????????????????????????????????????? ??????[Enter]??? ???????????????????????? &larr;??? ????????????????????? &rarr;??? ??????????????????</p>");
// }

// // ???????????????????????????
// function mark(id,cid) {
//     document.writeln("<div class=\"reader_mark1\"><a href=\"javascript:;\" onclick=\"showpop('/modules/article/addbookcase.php?id=" + id + "&cid=" + cid + "&ajax_request=1');\"></a></div>");
//     document.writeln("<div class=\"reader_mark0\"><a href=\"javascript:;\" onclick=\"showpop('/modules/article/uservote.php?id=" + id + "&ajax_request=1');\"></a></div>");
// }

//??????
// function addbookcasemark(bid, cid) {
//     url = "/modules/article/addbookcase.php?bid=" + bid + "&cid=" + cid + '&ajax_request=1';
//     $.post(url, function (res) {
//         alert(res.replace(/<br[^<>]*>/g, '\n'));
//     });
// }

//??????
function addbookcase(bid) {

    url = "/modules/article/addbookcase.php?bid=" + bid + '&ajax_request=1';
    $.post(url, function (res) {
        alert(res.replace(/<br[^<>]*>/g, '\n'));
    });
}

function keyevent() {
    var index_page = $("#link-index").attr("href");
    var prev_page =  $("#link-preview").attr("href");
    var next_page = $("#link-next").attr("href");

    function jumpPage() {
        var event = document.all ? window.event : arguments[0];
        if (event.keyCode == 37) document.location = prev_page;
        if (event.keyCode == 39) document.location = next_page;
        if (event.keyCode == 13) document.location = index_page;
    }

    document.onkeydown = jumpPage;
}

// //??????????????????
// function Go(url) {
//     function is_mobile() {
//         var regex_match = /(nokia|iphone|android|motorola|^mot-|softbank|foma|docomo|kddi|up.browser|up.link|htc|dopod|blazer|netfront|helio|hosin|huawei|novarra|CoolPad|webos|techfaith|palmsource|blackberry|alcatel|amoi|ktouch|nexian|samsung|^sam-|s[cg]h|^lge|ericsson|philips|sagem|wellcom|bunjalloo|maui|symbian|smartphone|midp|wap|phone|windows ce|iemobile|^spice|^bird|^zte-|longcos|pantech|gionee|^sie-|portalmmm|jigs browser|hiptop|^benq|haier|^lct|operas*mobi|opera*mini|320x320|240x320|176x220)/i;
//         return navigator.userAgent == null || regex_match.exec(navigator.userAgent) != null;
//     }
//
//     if (is_mobile()) {
//         window.top.location.href = url;
//     }
// }

// // ??????????????????
// function bd_push() {
//     var bp = document.createElement('script');
//     var curProtocol = window.location.protocol.split(':')[0];
//     if (curProtocol === 'https') {
//         bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
//     }
//     else {
//         bp.src = 'http://push.zhanzhang.baidu.com/push.js';
//     }
//     var s = document.getElementsByTagName("script")[0];
//     s.parentNode.insertBefore(bp, s);
// }

// function jx(){
//     document.writeln("<script async src=\'//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\'></script>");
//     document.writeln("<!-- ??????300 -->");
//     document.writeln("<ins class=\'adsbygoogle\'");
//     document.writeln("     style=\'display:inline-block;width:300px;height:250px\'");
//     document.writeln("     data-ad-client=\'ca-pub-4554708189793180\'");
//     document.writeln("     data-ad-slot=\'5679245558\'></ins>");
//     document.writeln("<script>");
//     document.writeln("(adsbygoogle = window.adsbygoogle || []).push({});");
//     document.writeln("</script>");
// }

// function hf(){
//     document.writeln("<script async src=\'//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\'></script>");
//     document.writeln("<!-- ????????? -->");
//     document.writeln("<ins class=\'adsbygoogle\'");
//     document.writeln("     style=\'display:block\'");
//     document.writeln("     data-ad-client=\'ca-pub-4554708189793180\'");
//     document.writeln("     data-ad-slot=\'2725779154\'");
//     document.writeln("     data-ad-format=\'auto\'></ins>");
//     document.writeln("<script>");
//     document.writeln("(adsbygoogle = window.adsbygoogle || []).push({});");
//     document.writeln("</script>");
// }