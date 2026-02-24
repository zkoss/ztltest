import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F55-ZK-318TestCafe`
	.page`http://localhost:8080/zktest/test2/F55-ZK-318.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F55-ZK-318TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd", true))).$n("real"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton one clicked"),
			"Should has this message: combobutton one clicked",
		);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton one opened"),
			"Should has this message: combobutton one opened",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBoxTwo", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("popup opened"),
			"Should has this message: popup opened",
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppOne", true).$n()).is(":visible"),
			)(),
		)
		.ok("combobutton one should opened");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton one closed"),
			"Should has this message: combobutton one closed",
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppOne", true).$n()).is(":visible"),
			)(),
		)
		.notOk("combobutton one should closed");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd2", true))).$n("real"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton two clicked"),
			"Should has this message: combobutton two clicked",
		);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd2", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton two opened"),
			"Should has this message: combobutton two opened",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBoxTwo", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("popup opened"),
			"Should has this message: popup opened",
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppTwo", true).$n()).is(":visible"),
			)(),
		)
		.ok("combobutton two should opened");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd2", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton two closed"),
			"Should has this message: combobutton two closed",
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppTwo", true).$n()).is(":visible"),
			)(),
		)
		.notOk("combobutton two should closed");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd2", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton two opened"),
			"Should has this message: combobutton two opened",
		);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(About)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Menu)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Color)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-colorpalette-popup").is(":visible"),
			)(),
		)
		.ok("Color picker should opened");
	await t.click(Selector(() => zk.Desktop._dt.$f("mbHelp", true).$n()));
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(About1)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-label:contains(message box)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd2", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton two opened"),
			"Should has this message: combobutton two opened",
		);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(About)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Menu)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Color)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Color)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-colorpalette-popup").is(":visible"),
			)(),
		)
		.ok("Color picker should opened");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton one opened"),
			"Should has this message: combobutton one opened",
		);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppOne", true).$n()).is(":visible"),
			)(),
		)
		.ok("combobutton one should opened");
	await t.click(
		Selector(() => zk.Desktop._dt.$f("li", true).firstChild.$n()),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppOne", true).$n()).is(":visible"),
			)(),
		)
		.notOk("combobutton one should opened");
	await t.click(Selector(() => zk.Desktop._dt.$f("cbx", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(change image)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@button:contains(open combobutton one)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton one opened"),
			"Should has this message: combobutton one opened",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBoxTwo", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("popup opened"),
			"Should has this message: popup opened",
		);
	await t.click(Selector(() => jq(".z-label:contains(message box)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@button:contains(open combobutton two)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBox", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("combobutton two opened"),
			"Should has this message: combobutton two opened",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("messageBoxTwo", true).$n().value,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("menu popup opened"),
			"Should has this message: menu popup opened",
		);
	await t.click(Selector(() => jq(".z-label:contains(message box)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cbx", true).$n("real")));
	await ztl.waitResponse(t);
	let bgColor_cafe = await ClientFunction(
		() => jq("@window .z-window-content")[0].style.backgroundColor,
	)();
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd2", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(About)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Menu)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Color)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-menu:contains(Color)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-colorpalette-color:eq(22)")[0].click();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq("@window .z-window-content")[0].style
							.backgroundColor,
				)(),
			),
		)
		.notEql(
			ztl.normalizeText(bgColor_cafe),
			"The background color didn't change",
		);
	await t.click(Selector(() => jq("@button:contains(change child)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppTwo", true).$n()).is(":visible"),
			)(),
		)
		.ok("combobutton two should opened");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("bd2", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("ppOne", true).$n()).is(":visible"),
			)(),
		)
		.ok("combobutton one should opened");
});
