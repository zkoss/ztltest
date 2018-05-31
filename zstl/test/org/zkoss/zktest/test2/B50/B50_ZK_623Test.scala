/* B50_ZK_623Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Dec 05 14:28:08 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}

/**
  * A test class for bug ZK-623
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-623.zul,A,E,Hbox,Vbox,hflex,vflex,VisionTest")
class B50_ZK_623Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>	
					You should see the green area have height 400px, no larger.
				</div>
				<vbox id="vbox" height="400px" width="200px" style="background-color:green">
					<div id="div1" vflex="min">
						<div height="200px" style="background-color:blue">Div 1</div>
					</div>
					<div id="div2" vflex="1" width="100px" style="background-color:red">
						Div 2
					</div>
				</vbox>
			</zk>

    """
    runZTL(zscript, () => {
      var vbox: Widget = engine.$f("vbox");

      verifyTrue("the height of vbox should equal to 400",
        jq(vbox.$n()).height() == 400);
    })
  }
}