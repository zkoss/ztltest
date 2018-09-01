/* B30_1744427Test.java

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


class B30_1744427Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabind() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk:window xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			           xmlns:zk="http://www.zkoss.org/2005/zul" 
			           xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd "
			           border="normal" width="100%">
			1. Select a value from one of the listboxes. 
			2. If no NullPointerException, it is right.
			    <zk:zscript>
			    	import org.zkoss.zktest.test.MyBean;
			    	
			    	MyBean mb = new MyBean();
			    </zk:zscript>
			
				<zk:listbox
				self="@{bind(model='mb.codeFilterTypeValues', selectedItem='mb.codeFilterType')}"
				id="codeFilterType" rows="1" mold="select">
					<zk:listitem self="@{bind(_var='compType')}">
						<zk:listcell self="@{bind(label='compType',value='compType')}"/>
					</zk:listitem>
				</zk:listbox>
				
				<zk:listbox id="titleFilterType" rows="1" mold="select"
				self="@{bind(model='mb.titleFilterTypeValues', selectedItem='mb.titleFilterType')}">
					<zk:listitem self="@{bind(_var='titleCompType')}">
						<zk:listcell self="@{bind(label='titleCompType',value='titleCompType')}"/>
					</zk:listitem>
				</zk:listbox>
				
			</zk:window>
		 """
    val ztl$engine = engine()
    val codeFilterType = ztl$engine.$f("codeFilterType")
    val titleFilterType = ztl$engine.$f("titleFilterType")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      select(codeFilterType, "STARTS")
      verifyFalse(jq(".z-window-highlighted").exists())
      select(codeFilterType, "CONTAINS")
      verifyFalse(jq(".z-window-highlighted").exists())
      select(titleFilterType, "STARTS")
      verifyFalse(jq(".z-window-highlighted").exists())
      select(titleFilterType, "CONTAINS")
      verifyFalse(jq(".z-window-highlighted").exists())
    })
  }
}



