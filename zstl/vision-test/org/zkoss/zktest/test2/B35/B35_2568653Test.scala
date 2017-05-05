/* B35_2568653Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:47:09 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZK
import org.junit.Test

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B35-2568653.zul,A,E,Portallayout,VisionTest")
class B35_2568653Test extends ZTL4ScalaTestCase {
	
  @Test
  def testCase() = {
		val zscript = """
			<zk>
				1.Please move the "Google Tools" from up to down after the "LabPixies Clock".
				<separator/>
				2.Click the "redraw" button, and then the result is same as before (It means before changed).
				<button label="redraw" onClick='portal.invalidate()'/>
				<portallayout id="portal">
					<portalchildren style="padding: 5px" width="30%">
						<panel id="p1" height="150px" title="Google Tools" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
							<panelchildren>
								<iframe width="100%" height="100%" src="http://3.gmodules.com/ig/ifr?url=http://www.google.com/ig/modules/toolspromo.xml&amp;nocache=0&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=3&amp;ifpctok=5090480830848781425&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMAs4ACwrMBA4ACwrMBI4ACwrMBM4ACw/zYieI_ujwr4.js"/>
							</panelchildren>
						</panel>
						<panel id="Clock" height="300px" title="LabPixies Clock" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
							<panelchildren>
								<iframe width="100%" height="100%" src="http://ig.gmodules.com/gadgets/ifr?url=http://www.labpixies.com/campaigns/trio/trio.xml&amp;nocache=0&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=35&amp;ifpctok=7430207052966295609&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
							</panelchildren>
						</panel>
					</portalchildren>
					<!--<portalchildren style="padding: 5px" width="30%">
						<panel height="300px" title="ToDo" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
							<panelchildren>
								<iframe width="100%" height="100%" src="http://06bv6fa68lc8dljc3a5rv1h8tgo79oq6.ig.ig.gmodules.com/gadgets/ifr?url=http://www.labpixies.com/campaigns/todo/todo.xml&amp;nocache=0&amp;up_saved_tasks=&amp;upt_saved_tasks=hidden&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=31&amp;ifpctok=-1474109439244469874&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
							</panelchildren>
						</panel>
						<panel height="100px" title="Wikipedia" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
							<panelchildren>
								<iframe width="100%" height="100%" src="http://29.gmodules.com/ig/ifr?url=http://wpsearchbar.wikia.com/common/wpsearchbar.xml&amp;nocache=0&amp;up_mylang=&amp;upt_mylang=enum&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=29&amp;ifpctok=4012247812086609177&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
							</panelchildren>
						</panel>
					</portalchildren>-->
					<portalchildren style="padding: 5px" width="40%">
						<panel height="400px" title="Trio" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
							<panelchildren>
								<iframe width="100%" height="100%" src="http://ig.gmodules.com/gadgets/ifr?url=http://www.labpixies.com/campaigns/trio/trio.xml&amp;nocache=0&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=35&amp;ifpctok=7430207052966295609&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
							</panelchildren>
						</panel>
					</portalchildren>
				</portallayout>
			</zk>
		"""
runZTL(zscript, () => {
			sleep(500)
			
			verifyImage();
			val position = "10,10"
	        val src = jq("$p1").find(".z-panel-header")
	        mouseMoveAt(src, position)
	        waitResponse
	
	        mouseDownAt(src, position)
	        waitResponse
	
	        val newPosition = "10,600"
	        mouseMoveAt(src, newPosition)
	        waitResponse
	        
	        mouseUpAt(src, newPosition)
	        waitResponse
	        
			sleep(1200)
			verifyImage();
			click(jq("@button"))
			waitResponse()
			sleep(1200)
			verifyImage();
		})
	}
}
