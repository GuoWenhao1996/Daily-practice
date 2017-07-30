/**
 * Created by guowh on 2016/12/25.
 */

/*
 *打开或关闭菜单
 * @param thisz 触发事件对象
 */
function openOrCloseMenu(thisz) {
    //父节点菜单ID
    var parentID = thisz.id;
    //获得所有子节点
    var subNodes = document.getElementsByName(parentID);
    //判断显示属性
    //1、判断是否存在子节点,不存在返回
    if (subNodes.length < 1) {
        return;
    }
    //2、存在，隐藏就显示，显示就隐藏
    if (subNodes[0].style.display == "none") {
        for (i = 0; i < subNodes.length; i++)
            subNodes[i].style.display = "block";//隐藏
    }
    else {
        for (i = 0; i < subNodes.length; i++)
            subNodes[i].style.display = "none";//显示
    }
//            alert("状态："+subNodes[0].style.display)
}
/*
 *全选与反选
 */
function checkedOrUnchecked(thisz) {
    //获得所有数据行的复选框
    var idsArr = document.getElementsByName("ids");
    //循环修改选中状态属性
    for (i = 0; i < idsArr.length; i++) {
        idsArr[i].checked = thisz.checked;
    }
}
/*
 * 获得选中复选框的数量
 */
function getSelectedCount() {
    //获得所有数据行的复选框
    var idsArr = document.getElementsByName("ids");
    //选中复选框的数量
    var count = 0;
    //循环统计选中复选框的数量
    for (i = 0; i < idsArr.length; i++) {
        if (idsArr[i].checked)
            count++;
    }
    //返回数量
    return count;
}
/*
 * 添加用户
 */
function useradd() {
    ////获取选中对象
    //var form = document.getElementById("form2");
    ////设置提交的路径
    //form.action = "useradd.html";
    ////提交表单
    //form.submit();
    location.href = "useradd.html";
}
/*
 * 添加部门
 */
function deptadd() {
    location.href = "deptadd.html";
}

/*
 * 修改用户
 */
function userupdate() {
    //获得选中的数量
    var count = getSelectedCount();
    //判断是否可以提交表单
    if (count != 1) {
        alert("请选中一条要修改的记录!");
        return;
    }
    //获取选中对象
    var form = document.getElementById("form2");
    //设置提交的路径
    form.action = "userupdate.html";
    //提交表单
    form.submit();
}
/*
 * 修改部门
 */
function deptupdate() {
    //获得选中的数量
    var count = getSelectedCount();
    //判断是否可以提交表单
    if (count != 1) {
        alert("请选中一条要修改的记录!");
        return;
    }
    //获取选中对象
    var form = document.getElementById("form2");
    //设置提交的路径
    form.action = "deptupdate.html";
    //提交表单
    form.submit();
}

/*
 * 删除
 */
function deleted() {
    //获得选中的数量
    var count = getSelectedCount();
    //判断是否选中了数据行
    if (count == 0) {
        alert("请选中要删除的记录!");
        return;
    }
    //弹出选择对话框
    if (confirm("您是否要删除选中的记录？")) {
        //获取选中对象
        var form = document.getElementById("form2");
        //设置提交的路径
        form.action = "";
        //提交表单
        form.submit();
    }
}