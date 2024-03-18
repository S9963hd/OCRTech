document.addEventListener("DOMContentLoaded", function() {
    alert("Redirected");

    var copyButton = document.getElementById("copyButton");
    var textToCopyElement = document.getElementById("textToCopy");

    if (!copyButton || !textToCopyElement) {
        console.error("Button or text element not found.");
        return;
    }

    copyButton.addEventListener("click", function() {
        var textToCopy = textToCopyElement.innerText;

        try {
            var tempTextArea = document.createElement("textarea");
            tempTextArea.value = textToCopy;
            document.body.appendChild(tempTextArea);
            tempTextArea.select();
            document.execCommand("copy");
            document.body.removeChild(tempTextArea);
            alert("Text copied to clipboard: ");
        } catch (err) {
            console.error("Unable to copy: ", err);
            alert("Failed to copy text.");
        }
    });
});
