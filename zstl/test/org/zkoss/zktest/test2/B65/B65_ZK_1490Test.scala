package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1490.zul")
class B65_ZK_1490Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk xmlns:w="client">
                    <html>
                      Testing instructions: None
		
		Expected results:
                      <ul>
                        <li>No JavaScript exceptions should occur.</li>
                      </ul>
                    </html>
                    <borderlayout height="500px" width="500px">
                      <north>
                        <attribute w:name="onBind">
                          <![CDATA[
				this.setSize('20%');
				zk.log('NORTH', this.getSize());
			]]>
                        </attribute>
                        Hello North
                      </north>
                      <west>
                        <attribute w:name="onBind">
                          <![CDATA[
			  this.setSize('20%');
			  zk.log('WEST', this.getSize());
			]]>
                        </attribute>
                        Hello West
                      </west>
                      <center>Hello Center</center>
                      <east>
                        <attribute w:name="onBind">
                          <![CDATA[
			  this.setSize('20%');
			  zk.log('EAST', this.getSize());
			]]>
                        </attribute>
                        Hello East
                      </east>
                      <south>
                        <attribute w:name="onBind">
                          <![CDATA[
			  this.setSize('20%');
			  zk.log('SOUTH', this.getSize());
			]]>
                        </attribute>
                        Hello South
                      </south>
                    </borderlayout>
                  </zk>
"""
    runZTL(zscript,
      () => {
        verifyTrue("No JavaScript exceptions should occur.", !jq(".z-window-modal").exists())
      })

  }
}
