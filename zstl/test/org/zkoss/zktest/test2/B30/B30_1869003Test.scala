/* B30_1869003Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1869003Test extends ZTL4ScalaTestCase {
  @Test
  def testDataBinding() = {
    var zscript =
      """
				<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?> 
				<window id="testwin" xmlns="http://www.zkoss.org/2005/zul"  
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  > 
				<html><![CDATA[
				1. Select checkbox of the first row.<br/>
				2. Click on the "Click Me" column header in "Top Grid" and the checked row is removed.<br/>
				3. The checkbox of the new first row should not be checked.(Error if you see it checked)<br/>
				]]></html> 
				<zscript> 
					import java.util.ArrayList; 
					import java.util.HashSet; 
					 
					public class Base 
					{ 
						public String name; 
						public Base(String n) 
						{ 
							this.name=n; 
							this.items = new HashSet(); 
						} 
					}; 
					 
					Set _wdBundles = new HashSet(); 
					 
					baseA = new Base("Row A"); 
					_wdBundles.add(baseA); 
					 
					baseB = new Base("Row B");  
					_wdBundles.add(baseB); 
					 
					baseC = new Base("Row C");  
					_wdBundles.add(baseC); 
					
					void removeTop(Grid g) 
					{ 
						rows = g.getFellow("topgrid"); 
						List rowList = new ArrayList(rows.getChildren());
						int x = 0; 
						for(Row r:rowList) 
						{ 
							Checkbox check = (Checkbox) r.getFirstChild(); 
							if(check.isChecked()) 
							{ 
								g.getModel().remove(r.getValue()); 
							} 
						} 
					} 
				</zscript> 
				 
				<grid id="mygrid" mold="paging" pageSize="8" width="600px" model="@{_wdBundles}"> 
					<columns> 
						<column label="Click Me" onClick="removeTop(self.parent.parent)"/> 
						<column label="Bundle" width="35%"/> 
					</columns> 
					<rows id="topgrid"> 
						<row self="@{each='bundle'}" value="@{bundle}"> 
							<checkbox/> 
							<label value="@{bundle.name}"/> 
						</row> 
					</rows> 
				</grid> 
				
				</window> 
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val testwin = ztl$engine.$f("testwin")
    val mygrid = ztl$engine.$f("mygrid")
    val topgrid = ztl$engine.$f("topgrid")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      click(jq(".z-checkbox input[id*=\"real\"]:eq(0)"))
      waitResponse()
      verifyTrue(jq(".z-checkbox input[id*=\"real\"]:eq(0)").is(":checked"))
      clickAt(jq(".z-column:eq(0)"), "1,1")
      waitResponse()
      verifyFalse(jq(".z-checkbox input[id*=\"real\"]:eq(0)").is(":checked"))
    })
  }
}



