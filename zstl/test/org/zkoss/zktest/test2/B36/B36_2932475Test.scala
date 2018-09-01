/* B36_2932475Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2932475Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk xmlns="http://www.zkoss.org/2005/zul"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd">

    <zscript language="Java"><![CDATA[

        class OuterWindow extends org.zkoss.zul.Window {
            private boolean outerProperty = true;

            public boolean getOuterProperty() {
                return outerProperty;
            }

            public void setOuterProperty(boolean outerProperty) {
                this.outerProperty = outerProperty;
            }
        }

        class InnerWindow extends org.zkoss.zul.Window {
            private boolean innerProperty = false;

            public boolean getInnerProperty() {
                return innerProperty;
            }

            public void setInnerProperty(boolean innerProperty) {
                this.innerProperty = innerProperty;
            }
        }

    ]]></zscript>

    <html><![CDATA[
        <ol>
        <li>Check and uncheck the two checkbox.</li>
        <li>If a NoSuchMethodException is thrown, it is a bug. Otherwise, it is OK.</li>
        </ol>
     ]]></html>

    <window title="window" use="OuterWindow" border="normal">
        <checkbox label="outer property" checked="@{spaceOwner.outerProperty}" />
        <window title="window" use="InnerWindow" border ="normal">
            <checkbox label="inner property" checked="@{spaceOwner.innerProperty}" />
        </window>
    </window>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      click(jq("@checkbox:eq(0) input"))
      waitResponse()
      click(jq("@checkbox:eq(0) input"))
      waitResponse()
      click(jq("@checkbox:eq(1) input"))
      waitResponse()
      click(jq("@checkbox:eq(1) input"))
      waitResponse()
      verifyFalse(jq("@window:not(@window[title=\"window\"])").exists())
    })
  }
}



