package ${package}.entity.po;

import com.common.base.BasePO;
import com.common.process.DemoColumn;
import com.common.process.DemoTable;

/**
* @author : ${author}
* @date : ${date}
* @version 1.0
*/
@DemoTable("${classNameLower}")
public class ${className}PO extends BasePO {

<#list columns as column>
	@DemoColumn("${column.columnTableName}")
	private ${column.columnType} ${column.columnName};

</#list>
	// setter and getter

<#list columns as column>
	public ${column.columnType} get${column.columnNameUp}(){
		return ${column.columnName};
	}

	public void set${column.columnNameUp}(${column.columnType} ${column.columnName}){
		this.${column.columnName} = ${column.columnName};
	}
</#list>

}
