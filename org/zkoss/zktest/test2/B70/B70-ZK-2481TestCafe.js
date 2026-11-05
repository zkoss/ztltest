import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2481TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2481TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window width="100%" height="100%" title="Testing with ZK \${desktop.webApp.version}" border="normal">
    <navbar orient="horizontal" collapsed="false">
        <nav label="Application Menu">
            <navitem label="Dashbaord"/>
                <nav label="Admin" badgeText=">>">
                    <navitem label="Analysis Hierarchies Administration"/>
                    <navitem label="Fab Layout Administration"/>
                    <navitem label="PULSE Adminstration Client"/>
                    <nav label="PULSE Documentation" badgeText=">>">
                        <navitem label="PULSE Administrators Guide"/>
                        <navitem label="PULSE Integerators Guide"/>
                        <navitem label="PULSE Release Notes"/>
                        <navitem label="PULSE Users Guide"/>
                    </nav>
                </nav>
            <navitem label="Sitemap"/>
            <navitem label="Help"/>
            <navitem label="About..."/>
        </nav>
    </navbar>
    <separator height="100px"/>
    <div style="float:right">
        <label value="The same navbar with float:right"/>
        <separator/>
        <navbar orient="horizontal" collapsed="false">
            <nav label="Application Menu" >
                <navitem label="Dashbaord"/>
                <nav label="Admin" badgeText=">>">
                    <navitem label="Analysis Hierarchies Administration"/>
                    <navitem label="Fab Layout Administration"/>
                    <navitem label="PULSE Adminstration Client"/>
                    <nav label="PULSE Documentation" badgeText=">>">
                        <navitem label="PULSE Administrators Guide"/>
                        <navitem label="PULSE Integerators Guide"/>
                        <navitem label="PULSE Release Notes"/>
                        <navitem label="PULSE Users Guide"/>
                    </nav>
                </nav>
                <navitem label="Sitemap"/>
                <navitem label="Help"/>
                <navitem label="About..."/>
            </nav>
        </navbar>
    </div>
</window>`,
	);
	await t.click(Selector(() => jq(".z-navbar:last a")[0]));
	await ztl.waitResponse(t);
	const dropdown = Selector(
		() => jq(".z-navbar:last>ul>li>ul")[0],
	).addCustomDOMProperties({
		insideWindow: (ul) => {
			const box = ul.getBoundingClientRect();
			return (
				box.left >= 0 &&
				box.right <= document.documentElement.clientWidth
			);
		},
	});
	await t.expect(dropdown.visible).ok("the nav should open");
	await t
		.expect(dropdown.insideWindow)
		.ok("the opened nav should show all its items inside the window");
});
