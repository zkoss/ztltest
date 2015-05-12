package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-602.zul")
class B60_ZK_602Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk><vlayout id="vb">
                        <html><![CDATA[
<ol>
	<li>Click the "Clone by Serialization" button and then another window is created and append.</li>
	<li>Click any of the OK button in the new window, a message saying "dst1: onOK" will be shown.</li>
	<li>Click the "Clone" button, and repeat 1 and 2 (the message shall become "dst2: onOK").</li>
</ol>
]]></html>
                        <window id="w" title="Test of Forward Conditions" border="normal" onOK='alert(self.id+": onOK")' onCancel='alert(self.id+": onCancel")'>
                          <window title="Inner" border="normal">
                            <button label="OK" forward="...onOK"/>
                            <button label="Cancel" forward="...onCancel"/>
                          </window>
                          <button label="OK" forward="onOK"/>
                          <button label="Cancel" forward="onCancel"/>
                        </window>
                        ${ w.uuid }
                        <zscript>
                          int cnt = 0;
                        </zscript>
                        <button label="Clone by Serialization">
                          <attribute name="onClick"><![CDATA[{
	import java.io.*;
	ByteArrayOutputStream boa = new ByteArrayOutputStream();
	new ObjectOutputStream(boa).writeObject(w);
	byte[] bs = boa.toByteArray();
	Object n = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
	n.setId("dst" + ++cnt);
	vb.insertBefore(n, self);
	vb.insertBefore(new Label(bs.length+" bytes copied"), self);
		}]]></attribute>
                        </button>
                        <button label="Clone">
                          <attribute name="onClick"><![CDATA[{
	Object n = w.clone();
	n.setId("dst" + ++cnt);
	vb.insertBefore(n, self);
		}]]></attribute>
                        </button>
                      </vlayout></zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button:contains(Clone by Serialization)"))
        waitResponse()

        val clone0Btn = jq(".z-window-embedded:contains(Test of Forward Conditions):eq(1)").find("@button:contains(OK):eq(1)")
        click(clone0Btn)
        waitResponse()
        
        val msgWindow = jq(".z-messagebox-window")
        val msg = msgWindow.find(".z-label").text()
        verifyEquals("a message saying 'dst1: onOK' will be shown.", msg, "dst1: onOK")
        
        val msgBtn = msgWindow.find(".z-button")
        click(msgBtn)
        waitResponse()
        
        click(jq("@button:contains(Clone)"))
        waitResponse()

        val clone1Btn = jq(".z-window-embedded:contains(Test of Forward Conditions):eq(2)").find("@button:contains(OK):eq(1)")

        click(clone1Btn)
        verifyEquals("a message saying 'dst1: onOK' will be shown.", msg, "dst1: onOK")
        
      })

  }
}
