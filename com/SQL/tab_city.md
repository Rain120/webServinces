<table align = "left">
    <tr>市信息表（tab_city）</tr>
    <tr>
      <td>字段名</td><td>字段类型</td><td>是否可为空</td><td>默认值</td><td>字段含义</td><td>注释</td>
    </tr>
    <tr>
        <td>id</td><td>number(4)</td><td>N</td><td></td><td>ID</td><td>主键</td>
    </tr>
    <tr>
        <td>ID</td><td>VARCHAR2(6)</td><td>Y</td><td></td><td>市标识</td><td></td>
    </tr>
    <tr>
        <td>city</td><td>VARCHAR2(50)</td><td>Y</td><td></td><td>市名称</td><td></td>
    </tr>
    <tr>
        <td>fathe</td><td>VARCHAR2(6)</td><td>Y</td><td></td><td>省份标识</td><td>关联<a href="https://github.com/Rain120/webServinces/blob/master/com/SQL/tab_province.md" target="_blank">tab_province</a>表provinceID字段</td>
    </tr>
</table>
