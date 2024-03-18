// JavaScript to handle the copy button functionality
alert("Redirected")
document.getElementById("copyButton").addEventListener("click", function() {
    // Get the text you want to copy
    var textToCopy = document.getElementById("textToCopy").innerText;

    // Create a temporary textarea element to hold the text
    var tempTextArea = document.createElement("textarea");
    tempTextArea.value = textToCopy;

    // Append the textarea to the document
    document.body.appendChild(tempTextArea);

    // Select the text in the textarea
    tempTextArea.select();

    // Copy the selected text to the clipboard
    document.execCommand("copy");

    // Remove the temporary textarea
    document.body.removeChild(tempTextArea);

    // Alert or display a message to indicate successful copy
    alert("Text copied to clipboard: " + textToCopy);
});
