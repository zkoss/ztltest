/* B50_ZK_873Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 17:17:06 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-873
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-873.zul,B,E,Listbox,Listheader")
class B50_ZK_873Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<div height="20px" />
				<div>You should not see any selectall box in the list header</div>
				<div height="20px" />
				<listbox multiple="true" checkmark="true" mold="paging" pageSize="5">
					<custom-attributes org.zkoss.zul.listbox.rod="true"/>
					<listhead>
					<listheader id="headerOne" label="Name1"/>
					<listheader label="Address"/>
					</listhead> 
					<zk forEach="1,2,3,4,5,6,7,8,9">
					<listitem>
					<listcell label="Name ${each}"></listcell>
					<listcell label="Address ${each}"></listcell>
					</listitem>
					</zk>
				</listbox>	
				<listbox multiple="true" checkmark="true" mold="paging" pageSize="10">
					<custom-attributes org.zkoss.zul.listbox.rod="true"/>
					<listhead>
					<listheader id="headerTwo" label="Name2"/>
					<listheader label="Address2"/>
					</listhead> 
					<zk forEach="1,2,3,4,5,6,7,8,9">
					<listitem>
					<listcell label="Name ${each}"></listcell>
					<listcell label="Address ${each}"></listcell>
					</listitem>
					</zk>
				</listbox>
			</zk>

    """


   runZTL(zscript, () => {
   			var (headerOne: Widget,
    	     headerTwo: Widget) = (
    	        engine.$f("headerOne"),
    	        engine.$f("headerTwo")
    	    );
   			verifyFalse("Should no select-all checkbox",
   			    headerOne.$n("cm").exists());
   			verifyFalse("Should no select-all checkbox",
   			    headerTwo.$n("cm").exists());
		})
  }
}