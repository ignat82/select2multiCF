function disableField(fieldId) {
    AJS.$(`.Select2-Custom-${fieldId}`).prop("style", "pointer-events:none; opacity:0.5", "disabled", true);
    AJS.$(`.Select2-Custom-${fieldId} [role=option]`).prop("style", "pointer-events:none");
    AJS.$(`#${fieldId}-val`).prop("style", "pointer-events:none; opacity:0.5", "disabled", true);
    AJS.$(`#${fieldId}-val > span`).prop("style", "display:none");
}

function unDisableField(fieldId) {
    AJS.$(`.Select2-Custom-${fieldId}`).removeProp("style", "pointer-events:none; opacity:0.5", "disabled", true);
    AJS.$(`.Select2-Custom-${fieldId} [role=option]`).removeProp("style", "pointer-events:none");
    AJS.$(`#${fieldId}-val`).removeProp("style", "pointer-events:none; opacity:0.5", "disabled", true);
    AJS.$(`#${fieldId}-val > span`).removeProp("style", "display:none");
}

function hideField(fieldId) {
    AJS.$(`.Select2-Custom-${fieldId}`).hide();
    AJS.$(`#rowFor${fieldId}`).hide();
}

function showField(fieldId) {
    AJS.$(`.Select2-Custom-${fieldId}`).show();
    AJS.$(`#rowFor${fieldId}`).show();
}
