/* B50_ZK_872Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 15 10:57:54 CST 2012 , Created by benbai
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
 * A test class for bug ZK-872
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-872.zul,")
class B50_ZK_872Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<zscript>
					class MyModel extends SimpleGroupsModel {
						public MyModel(Object[][] data) {
							super(data);
						}
				
						public void update(int group) {
							fireEvent(org.zkoss.zul.event.GroupsDataEvent.CONTENTS_CHANGED, group, 0, 0);
						}		
					}
			
					Object[][] data = new Object[2][2];
					data[0][0] = "test0";
					data[0][1] = "test01";
					data[1][0] = "test1";
					data[1][1] = "test11";
					MyModel model = new MyModel(data);
					
					public void update(){
						model.update(0);model.update(1);
					}
				</zscript>
				<div width="100%">
				<custom-attributes org.zkoss.zul.grid.rod="true" />
					<grid id="grid" model="${model}" />
					<button id="button" label="Run" onClick="update();" />
				</div>
			</zk>

    """

   runZTL(zscript,
        () => {
        var button: Widget = engine.$f("button");

        click(button);
        waitResponse();
        verifyFalse("Should no exception",
            jq(".z-window-modal").exists());
    }
   );
  }
}