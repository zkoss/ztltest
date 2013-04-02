
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-053.zul,Flex")
class Z65_Flex_053Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk><hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Hlayout]" width="480px">
        <hlayout height="200px" width="200px">
            <calendar hflex="1" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
            <calendar hflex="2" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Hbox]" width="480px">
        <hbox height="200px" width="200px">
            <calendar hflex="1" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
            <calendar hflex="2" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
        </hbox>
    </window>
</hbox>
<hbox>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Hlayout, rounded]" width="480px">
        <hlayout height="200px" width="200px">
            <calendar hflex="1" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
            <calendar hflex="2" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
        </hlayout>
    </window>
    <window border="normal" height="360px"
        title="Proportional Flexibility: [Calendar, Hbox, rounded]" width="480px">
        <hbox height="200px" width="200px">
            <calendar hflex="1" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
            <calendar hflex="2" vflex="1" onCreate="self.value = new java.util.GregorianCalendar(2013, java.util.Calendar.OCTOBER, 20).getTime()" />
        </hbox>
    </window>
</hbox>
</zk>"""
    runZTL(zscript,
      () => {
        verifyImage()
      })

  }
}