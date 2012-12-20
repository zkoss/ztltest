package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-996.zul")
class B60_ZK_996Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<div>
                    Type something and wait a while. You shall see nothing changed in the textbox
	(while a number shown up after the textbox).
	If you saw the cursor is moved before the first charactger, it is a bug.
                    <separator bar="true"/>
                    <zscript>
                      int cnt = 0;
	void update(Component comp){
                        inf.value = "" + ++cnt;
                        comp.invalidate();
                      }
                    </zscript>
                    <textbox focus="true" onChange="update(self.parent);" instant="true"/>
                    <label id="inf"/>
                  </div>"""

    runZTL(zscript,
      () => {
        verifyEquals(jq("."), "")
      })

  }
}
