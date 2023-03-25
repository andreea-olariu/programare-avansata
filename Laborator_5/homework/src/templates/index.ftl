<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <#list documents as doc>
        <h1>${doc.getName()}</h1>
    </#list>
</body>
</html>