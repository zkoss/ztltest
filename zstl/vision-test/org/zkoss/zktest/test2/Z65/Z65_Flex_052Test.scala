
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-052.zul,Flex")
class Z65_Flex_052Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Calendar, rounded]" width="480px">
        <calendar onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" vflex="1"/>
    </window>
    <window border="normal" height="360px"
        title="Fit-the-Rest Flexibility: [Calendar]" width="480px">
        <calendar onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" vflex="1"/>
    </window>
</hbox>
</zk>"""
    runZTL(zscript,
      () => {       
        verifyImage()
      })

  }
}