/* B50_ZK_893Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 15:00:30 CST 2012 , Created by benbai
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
 * A test class for bug ZK-893
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-893.zul,B,E,Listbox,Listhead,Frozen")
class B50_ZK_893Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
			<div>Drag the scroll bar to right side.</div>
			<div>The alignement beetween columns header and column cell should be fine</div>
			<listbox id="listbox" width="800px">
			
			<frozen id="frozen" columns="2" ></frozen>
			
			<listhead sizable="true">
				<listheader label="A" width="100px"/>
				<listheader label="B" width="100px"/>
				<listheader label="C" width="100px"/>
				<listheader label="D" visible="false"  width="100px"/>
				<listheader label="E" width="100px"/>
				<listheader label="A" width="100px"/>
				<listheader label="B" visible="false"  width="100px"/>
				<listheader label="C" width="100px"/>
				<listheader label="D" width="100px"/>
				<listheader label="E" width="100px"/>
				<listheader label="A" visible="false"  width="100px"/>
				<listheader label="B" width="100px"/>
				<listheader label="C" width="100px"/>
				<listheader label="D" width="100px"/>
				<listheader label="E" width="100px"/>
				<listheader label="A" width="100px"/>
				<listheader label="B" visible="false"  width="100px"/>
				<listheader label="C" width="100px"/>
				<listheader label="D" width="100px"/>
				<listheader label="E" visible="false"  width="100px"/>
				<listheader label="A" width="100px"/>
				<listheader label="B" width="100px"/>
				<listheader label="C" width="100px"/>
				<listheader label="D" width="100px"/>
				<listheader label="E" width="100px"/>
			</listhead>
			
			<listitem>
				<listcell>Aaaaaaaaaaaaa</listcell>
				<listcell>Bbbbbbbbb</listcell>
				<listcell>Ccccccccccccc</listcell>
				<listcell>Ddddddddddddddddddddddd</listcell>
				<listcell>Eeeee</listcell>
				<listcell>Aaaaaaaaaaaaa</listcell>
				<listcell>Bbbbbbbbb</listcell>
				<listcell>Ccccccccccccc</listcell>
				<listcell>Ddddddddddddddddddddddd</listcell>
				<listcell>Eeeee</listcell>
				<listcell>Aaaaaaaaaaaaa</listcell>
				<listcell>Bbbbbbbbb</listcell>
				<listcell>Ccccccccccccc</listcell>
				<listcell>Ddddddddddddddddddddddd</listcell>
				<listcell>Eeeee</listcell>
				<listcell>Aaaaaaaaaaaaa</listcell>
				<listcell>Bbbbbbbbb</listcell>
				<listcell>Ccccccccccccc</listcell>
				<listcell>Ddddddddddddddddddddddd</listcell>
				<listcell>Eeeee</listcell>
				<listcell>Aaaaaaaaaaaaa</listcell>
				<listcell>Bbbbbbbbb</listcell>
				<listcell>Ccccccccccccc</listcell>
				<listcell>Ddddddddddddddddddddddd</listcell>
				<listcell>Eeeee</listcell>
			</listitem>
			</listbox>
			</zk>

    }


   runZTL(zscript, () => {
			var frozen: Widget = engine.$f("frozen");
			jq(frozen.$n("scrollX")).get(0).eval("scrollLeft = 200");
			var listheadOffset: Int =
				Integer.parseInt(jq(".z-listhead").find(".z-listheader").get(20).get("offsetLeft"));
			var listcellOffset: Int =
				Integer.parseInt(jq(".z-listitem").find(".z-listcell").get(20).get("offsetLeft"));
			System.out.println(listheadOffset - listcellOffset);
			verifyTrue("Listhead and listcell should aligned well",
			    (listheadOffset - listcellOffset) < 2);
		})
  }
}