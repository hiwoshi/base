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

<#list fields as field>
	/** ${field.remark} */
	@DemoColumn("${field.columnTableName}")
	private ${field.columnType} ${field.columnName};

</#list>
	// setter and getter

<#list fields as field>
	public ${field.columnType} get${field.columnNameUp}(){
		return ${field.columnName};
	}

	public void set${field.columnNameUp}(${field.columnType} ${field.columnName}){
		this.${field.columnName} = ${field.columnName};
	}
</#list>

}
