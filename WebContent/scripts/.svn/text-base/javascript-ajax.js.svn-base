function init() {
  dwr.engine.setActiveReverseAjax(true);
}

function deleteNsc(obj) {
  var text = dwr.util.getValue("content");
  alert(text);
/*
  var text = dwr.util.getValue("text");
  dwr.util.setValue("text", "");
  JavascriptChat.addMessage(text);
  */
//  JavascriptChat.addMessage(obj);
}
function receiveMessages(messages) {
  var chatlog = "";
  for (var data in messages) {
    chatlog = "<div>" + dwr.util.escapeHtml(messages[data].content) + "</div>" + chatlog;
  }
  dwr.util.setValue("chatlog", chatlog, { escapeHtml:false });
}
