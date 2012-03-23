/* F60_ZK_522Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 14:36:20 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

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
 * A test class for bug ZK-522
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-522.zul,F60,B,E,Tablelayout")
class F60_ZK_522Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>This page should displaied without any problem.</div>
				<tablelayout columns="3">
					<custom-attributes org.zkoss.zul.image.preload="true"/>
				    <tablechildren rowspan="2">
				        <window width="300px" height="500px" title="test window" border="normal" />
				    </tablechildren>
				    <tablechildren>
				        <listbox height="250px" width="250px">
				        	<listhead>
				        		<listheader label="test listbox" />
				        	</listhead>
				        	<listitem>
				       			<listcell> test listbox</listcell>
				       		</listitem>
				        </listbox>
				    </tablechildren>
				    <tablechildren>
						<groupbox mold="3d" height="250px" width="250px" open="true">
							<caption image="/test2/img/inet.png" label="Testing Group Box" />
							<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
						</groupbox>
				    </tablechildren>
				    <tablechildren colspan="2">
				        <window height="245px" title="test window" border="normal" />
				    </tablechildren>
				</tablelayout>
			</zk>

    }

    runZTL(zscript,
        () => {
        verifyTrue("The listbox in tablechildren is displayed well",
            jq(".z-listheader:contains(test listbox)").exists());
    }
   );
  }
}