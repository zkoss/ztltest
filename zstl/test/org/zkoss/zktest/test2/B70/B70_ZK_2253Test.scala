package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2253.zul")
class B70_ZK_2253Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2253.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Apr 14, 2014  3:42:11 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<zscript><![CDATA[
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.zkoss.zk.ui.impl.SimpleDesktopCache;
import org.zkoss.zk.ui.util.Configuration;


	public byte[] write(Object object) throws Exception {
		final ByteArrayOutputStream binOut = new ByteArrayOutputStream();
		final ObjectOutputStream out = new ObjectOutputStream(binOut);
		out.writeObject(object);
		out.flush();
		out.close();
		return binOut.toByteArray();
	}

	public Object read(byte[] data) throws Exception {
		final ByteArrayInputStream bIn = new ByteArrayInputStream(data);
		final ObjectInputStream in = new ObjectInputStream(bIn);
		return in.readObject();
	}

]]></zscript>
<button label="Click me, you should not see any Error dialog.">
<attribute name="onClick">
Configuration config = new Configuration();
SimpleDesktopCache sdc = new SimpleDesktopCache(config);
		try {
			read(write(sdc));
		} catch (Exception e) {
			alert("Error");
		}
</attribute>
</button>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      verifyFalse("no exception", jq(".z-window-modal").exists());
    })
    
  }
}