$('.createOrEditBook').val($.trim($(".createOrEditBook").val()))

function showAlert() {
    document.getElementById("mainTableAlert").setAttribute("style","display: block;")
}

function getNotificationPermission(){
    if (!("Notification" in window)) {
        alert('Ваш браузер не поддерживает HTML Notifications, его необходимо обновить.');
    }else if(Notification.permission !== "granted"){
        Notification.requestPermission(function (permission) {
            if (permission !== "granted") {
                alert('Вы запретили показывать уведомления');
                return false;
            } else{
                return true;
            }
        });
    }
}
function spawnNotification(title) {
    var n = new Notification(title);
    setTimeout(n.close.bind(n), 4000);
}
function sendNotification(title) {
    if(Notification.permission === "granted"){
        spawnNotification(title);
    }else{
        var permission = getNotificationPermission();
        if(permission === true){
            spawnNotification(title);
        }
    }
}