/* B50_ZK_549Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 29 11:25:49 CST 2012 , Created by benbai
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
 * A test class for bug ZK-549
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-549.zul,B,E,Groupbox,Caption")
class B50_ZK_549Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
			<div>The groupboxes below should not overlapped and have the same height.</div>
				<custom-attributes org.zkoss.zul.image.preload="true"/>
				<hbox>
					<groupbox id="gbx1" width="200px" height="200px" open="true">
						<caption image="/test2/img/inet.png" label="Testing Group Box" />
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx2" width="200px" mold="3d" height="200px" open="true">
						<caption image="/test2/img/inet.png" label="Testing Group Box" />
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx3" width="200px" height="200px" open="true" title="Testing Group Box">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx4" width="200px" mold="3d" height="200px" open="true" title="Testing Group Box">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx5" width="200px" height="200px" open="true">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx6" width="200px" mold="3d" height="200px" open="true">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
				</hbox>
				<hbox>
					<groupbox id="gbx7" width="200px" height="200px" open="true">
						<caption image="/test2/img/inet.png" label="Testing Group Box" />
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx8" width="200px" mold="3d" height="200px" open="true">
						<caption image="/test2/img/inet.png" label="Testing Group Box" />
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx9" width="200px" height="200px" open="true" title="Testing Group Box">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx10" width="200px" mold="3d" height="200px" open="true" title="Testing Group Box">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx11" width="200px" height="200px" open="true">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
					<groupbox id="gbx12" width="200px" mold="3d" height="200px" open="true">
						<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
					</groupbox>
				</hbox>
			</zk>

    }

    runZTL(zscript,
        () => {
        for (i <- 1 to 12) {
          var gbx: Widget = engine.$f("gbx"+i);
          var header: Element = null;
          verifyTrue("Height should be 200px",
              jq(gbx).height() == 200);

          header = gbx.$n("title");
          if (!header.exists())
            header = jq(gbx).find(".z-caption").get(0);
          if (header.exists()) {
	          click(header);
	          waitResponse();
	          click(header);
	          waitResponse();
	          verifyTrue("Height should be 200px",
	              jq(gbx).height() == 200);
          }
        }
    }
   );
  }
}