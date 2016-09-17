package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2861.zul")
class B80_ZK_2861Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      //check that messages are correctly showing in zk.log
      verifyEquals("{\"id1\":\"<value1>\",\"id2\":\"value2\",\"id3\":\"value2\"}\n", getZKLog())
      //check that the custom attributes are set correctly
      verifyEquals("{\"id1\":\"<value1>\",\"id2\":\"value2\",\"id3\":\"value2\"}", jq(".z-div").attr("testjson"))
    })
  }
}