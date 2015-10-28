package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2861.zul")
class B80_ZK_2861Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2861.zul

	Purpose:
		
	Description:
		
	History:
		Fri Sep  4 10:10:12 CST 2015, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.

-->
<zk>
    <label><![CDATA[
You should see '{"id1":"<value1>","id2":"value2","id3":"value2"}' in zk.log
    ]]></label>
<window apply="org.zkoss.bind.BindComposer" xmlns:ca="client/attribute">
    <zscript><![CDATA[
			import org.zkoss.json.JSONObject;
			JSONObject myJSON = new JSONObject();
			myJSON.put("id1", "<value1>");
			myJSON.put("id2", "value2");
			myJSON.put("id3", "value2");

		]]></zscript>
    <div ca:testJSON="${myJSON}">check this div attributes</div>
    <script>
        zk.afterMount(function () {
        zk.log(jq('@div').attr('testjson'));
        });
    </script>
</window>
</zk>

""" 
  runZTL(zscript,
    () => {
      //check that messages are correctly showing in zk.log
      verifyEquals("{\"id1\":\"<value1>\",\"id2\":\"value2\",\"id3\":\"value2\"}\n", getZKLog())
      //check that the custom attributes are set correctly
      verifyEquals("{\"id1\":\"<value1>\",\"id2\":\"value2\",\"id3\":\"value2\"}", jq(".z-div").attr("testjson"))
    })
  }
}