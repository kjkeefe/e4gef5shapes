# e4gef5shapes
An Eclipse e4 RCP application that uses GEF 5 to create and manipulate shapes. This project is a proof of concept to show how to accomplish a pure Eclipse e4 RCP application using GEF 5.x. I hope to also get the tycho headless RCP build working as well.

** This project has been updated for Eclipse 2020-12 **

## What is working 

- Eclipse e4 RCP product is launching a window
- Compiler errors and warnings are all resolved.
- Eclipse IDE is able to resolve all packages, plugins, features, etc.

## What is NOT working 

- At launch, there is some issue with javafx and this error is shown in the console:



## Getting Started

After checking out the code, instruct Eclipse to import the projects. There should be 11 (nested) projects altogether. 

Open the shapes.rcp.target file and click the "Set As Active Target Platform" link in the upper right corner.

Next, open the products/e4gef5shapes.product/e4gef5shapes.product product configuration file.

In the "Testing" section, click the "Launch an Eclipse application" link to launch the application. 

## Currently stuck!

At this point, the application window opens and is blank. The console window shows the following error output:

<pre>!SESSION 2021-02-12 16:39:02.466 -----------------------------------------------
eclipse.buildId=unknown
java.version=11.0.8
java.vendor=AdoptOpenJDK
BootLoader constants: OS=macosx, ARCH=x86_64, WS=cocoa, NL=en_US
Framework arguments:  -product org.eclipse.gef.mvc.examples.shapes.e4gef5shapes
Command-line arguments:  -product org.eclipse.gef.mvc.examples.shapes.e4gef5shapes -data /Users/kjkeefe/eclipse-workspace-mobius/../runtime-e4gef5shapes.product -dev file:/Users/kjkeefe/eclipse-workspace-mobius/.metadata/.plugins/org.eclipse.pde.core/e4gef5shapes.product/dev.properties -os macosx -ws cocoa -arch x86_64 -consoleLog

!ENTRY org.eclipse.osgi 4 0 2021-02-12 16:39:05.618
!MESSAGE An error occurred while automatically activating bundle org.eclipse.gef.mvc.examples.shapes (104).
!STACK 0
org.osgi.framework.BundleException: Exception in org.eclipse.gef.mvc.examples.shapes.ShapesPlugin.start() of bundle org.eclipse.gef.mvc.examples.shapes.
	at org.eclipse.osgi.internal.framework.BundleContextImpl.startActivator(BundleContextImpl.java:835)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.start(BundleContextImpl.java:763)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.startWorker0(EquinoxBundle.java:1011)
	at org.eclipse.osgi.internal.framework.EquinoxBundle$EquinoxModule.startWorker(EquinoxBundle.java:365)
	at org.eclipse.osgi.container.Module.doStart(Module.java:605)
	at org.eclipse.osgi.container.Module.start(Module.java:468)
	at org.eclipse.osgi.framework.util.SecureAction.start(SecureAction.java:506)
	at org.eclipse.osgi.internal.hooks.EclipseLazyStarter.postFindLocalClass(EclipseLazyStarter.java:117)
	at org.eclipse.osgi.internal.loader.classpath.ClasspathManager.findLocalClass(ClasspathManager.java:572)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.findLocalClass(ModuleClassLoader.java:346)
	at org.eclipse.osgi.internal.loader.BundleLoader.findLocalClass(BundleLoader.java:398)
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:477)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:171)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.loadClass(EquinoxBundle.java:616)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.createFromBundle(ReflectionContributionFactory.java:89)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.doCreate(ReflectionContributionFactory.java:60)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.create(ReflectionContributionFactory.java:42)
	at org.eclipse.e4.ui.workbench.renderers.swt.ContributedPartRenderer.createWidget(ContributedPartRenderer.java:132)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createWidget(PartRenderingEngine.java:999)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:659)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:765)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$2.run(PartRenderingEngine.java:730)
	at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:45)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createGui(PartRenderingEngine.java:714)
	at org.eclipse.e4.ui.workbench.renderers.swt.SWTPartRenderer.processContents(SWTPartRenderer.java:71)
	at org.eclipse.e4.ui.workbench.renderers.swt.WBWRenderer.processContents(WBWRenderer.java:666)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:673)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:765)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$2.run(PartRenderingEngine.java:730)
	at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:45)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createGui(PartRenderingEngine.java:714)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$5.run(PartRenderingEngine.java:1083)
	at org.eclipse.core.databinding.observable.Realm.runWithDefault(Realm.java:338)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.run(PartRenderingEngine.java:1046)
	at org.eclipse.e4.ui.internal.workbench.E4Workbench.createAndRunUI(E4Workbench.java:155)
	at org.eclipse.e4.ui.internal.workbench.swt.E4Application.start(E4Application.java:166)
	at org.eclipse.equinox.internal.app.EclipseAppHandle.run(EclipseAppHandle.java:203)
	at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.runApplication(EclipseAppLauncher.java:134)
	at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.start(EclipseAppLauncher.java:104)
	at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:401)
	at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:255)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.eclipse.equinox.launcher.Main.invokeFramework(Main.java:653)
	at org.eclipse.equinox.launcher.Main.basicRun(Main.java:590)
	at org.eclipse.equinox.launcher.Main.run(Main.java:1461)
	at org.eclipse.equinox.launcher.Main.main(Main.java:1434)
Caused by: java.lang.NoClassDefFoundError: javafx/embed/swt/FXCanvas
	at org.eclipse.gef.mvc.fx.ui.MvcFxUiModule.bindFXCanvasFactory(MvcFxUiModule.java:58)
	at org.eclipse.gef.mvc.fx.ui.MvcFxUiModule.configure(MvcFxUiModule.java:142)
	at com.google.inject.AbstractModule.configure(AbstractModule.java:59)
	at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:223)
	at com.google.inject.spi.Elements.getElements(Elements.java:101)
	at com.google.inject.spi.Elements.getElements(Elements.java:92)
	at com.google.inject.util.Modules$RealOverriddenModuleBuilder$1.configure(Modules.java:172)
	at com.google.inject.AbstractModule.configure(AbstractModule.java:59)
	at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:223)
	at com.google.inject.spi.Elements.getElements(Elements.java:101)
	at com.google.inject.internal.InjectorShell$Builder.build(InjectorShell.java:133)
	at com.google.inject.internal.InternalInjectorCreator.build(InternalInjectorCreator.java:103)
	at com.google.inject.Guice.createInjector(Guice.java:95)
	at com.google.inject.Guice.createInjector(Guice.java:72)
	at com.google.inject.Guice.createInjector(Guice.java:62)
	at org.eclipse.gef.mvc.examples.shapes.ShapesPlugin.start(ShapesPlugin.java:16)
	at org.eclipse.osgi.internal.framework.BundleContextImpl$2.run(BundleContextImpl.java:814)
	at org.eclipse.osgi.internal.framework.BundleContextImpl$2.run(BundleContextImpl.java:1)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.startActivator(BundleContextImpl.java:806)
	... 49 more
Caused by: java.lang.ClassNotFoundException: javafx.embed.swt.FXCanvas cannot be found by org.eclipse.gef.mvc.fx.ui_5.1.1.202012080300
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:516)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:171)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	... 69 more
Root exception:
java.lang.NoClassDefFoundError: javafx/embed/swt/FXCanvas
	at org.eclipse.gef.mvc.fx.ui.MvcFxUiModule.bindFXCanvasFactory(MvcFxUiModule.java:58)
	at org.eclipse.gef.mvc.fx.ui.MvcFxUiModule.configure(MvcFxUiModule.java:142)
	at com.google.inject.AbstractModule.configure(AbstractModule.java:59)
	at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:223)
	at com.google.inject.spi.Elements.getElements(Elements.java:101)
	at com.google.inject.spi.Elements.getElements(Elements.java:92)
	at com.google.inject.util.Modules$RealOverriddenModuleBuilder$1.configure(Modules.java:172)
	at com.google.inject.AbstractModule.configure(AbstractModule.java:59)
	at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:223)
	at com.google.inject.spi.Elements.getElements(Elements.java:101)
	at com.google.inject.internal.InjectorShell$Builder.build(InjectorShell.java:133)
	at com.google.inject.internal.InternalInjectorCreator.build(InternalInjectorCreator.java:103)
	at com.google.inject.Guice.createInjector(Guice.java:95)
	at com.google.inject.Guice.createInjector(Guice.java:72)
	at com.google.inject.Guice.createInjector(Guice.java:62)
	at org.eclipse.gef.mvc.examples.shapes.ShapesPlugin.start(ShapesPlugin.java:16)
	at org.eclipse.osgi.internal.framework.BundleContextImpl$2.run(BundleContextImpl.java:814)
	at org.eclipse.osgi.internal.framework.BundleContextImpl$2.run(BundleContextImpl.java:1)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.startActivator(BundleContextImpl.java:806)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.start(BundleContextImpl.java:763)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.startWorker0(EquinoxBundle.java:1011)
	at org.eclipse.osgi.internal.framework.EquinoxBundle$EquinoxModule.startWorker(EquinoxBundle.java:365)
	at org.eclipse.osgi.container.Module.doStart(Module.java:605)
	at org.eclipse.osgi.container.Module.start(Module.java:468)
	at org.eclipse.osgi.framework.util.SecureAction.start(SecureAction.java:506)
	at org.eclipse.osgi.internal.hooks.EclipseLazyStarter.postFindLocalClass(EclipseLazyStarter.java:117)
	at org.eclipse.osgi.internal.loader.classpath.ClasspathManager.findLocalClass(ClasspathManager.java:572)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.findLocalClass(ModuleClassLoader.java:346)
	at org.eclipse.osgi.internal.loader.BundleLoader.findLocalClass(BundleLoader.java:398)
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:477)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:171)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.loadClass(EquinoxBundle.java:616)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.createFromBundle(ReflectionContributionFactory.java:89)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.doCreate(ReflectionContributionFactory.java:60)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.create(ReflectionContributionFactory.java:42)
	at org.eclipse.e4.ui.workbench.renderers.swt.ContributedPartRenderer.createWidget(ContributedPartRenderer.java:132)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createWidget(PartRenderingEngine.java:999)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:659)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:765)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$2.run(PartRenderingEngine.java:730)
	at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:45)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createGui(PartRenderingEngine.java:714)
	at org.eclipse.e4.ui.workbench.renderers.swt.SWTPartRenderer.processContents(SWTPartRenderer.java:71)
	at org.eclipse.e4.ui.workbench.renderers.swt.WBWRenderer.processContents(WBWRenderer.java:666)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:673)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:765)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$2.run(PartRenderingEngine.java:730)
	at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:45)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createGui(PartRenderingEngine.java:714)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$5.run(PartRenderingEngine.java:1083)
	at org.eclipse.core.databinding.observable.Realm.runWithDefault(Realm.java:338)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.run(PartRenderingEngine.java:1046)
	at org.eclipse.e4.ui.internal.workbench.E4Workbench.createAndRunUI(E4Workbench.java:155)
	at org.eclipse.e4.ui.internal.workbench.swt.E4Application.start(E4Application.java:166)
	at org.eclipse.equinox.internal.app.EclipseAppHandle.run(EclipseAppHandle.java:203)
	at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.runApplication(EclipseAppLauncher.java:134)
	at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.start(EclipseAppLauncher.java:104)
	at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:401)
	at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:255)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.eclipse.equinox.launcher.Main.invokeFramework(Main.java:653)
	at org.eclipse.equinox.launcher.Main.basicRun(Main.java:590)
	at org.eclipse.equinox.launcher.Main.run(Main.java:1461)
	at org.eclipse.equinox.launcher.Main.main(Main.java:1434)
Caused by: java.lang.ClassNotFoundException: javafx.embed.swt.FXCanvas cannot be found by org.eclipse.gef.mvc.fx.ui_5.1.1.202012080300
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:516)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:171)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	... 69 more

!ENTRY org.eclipse.e4.ui.workbench 4 0 2021-02-12 16:39:05.621
!MESSAGE Unable to load class 'org.eclipse.gef.mvc.examples.shapes.view.MainPart' from bundle '104'
!STACK 0
java.lang.ClassNotFoundException: An error occurred while automatically activating bundle org.eclipse.gef.mvc.examples.shapes (104).
	at org.eclipse.osgi.internal.hooks.EclipseLazyStarter.postFindLocalClass(EclipseLazyStarter.java:126)
	at org.eclipse.osgi.internal.loader.classpath.ClasspathManager.findLocalClass(ClasspathManager.java:572)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.findLocalClass(ModuleClassLoader.java:346)
	at org.eclipse.osgi.internal.loader.BundleLoader.findLocalClass(BundleLoader.java:398)
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:477)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:171)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.loadClass(EquinoxBundle.java:616)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.createFromBundle(ReflectionContributionFactory.java:89)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.doCreate(ReflectionContributionFactory.java:60)
	at org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory.create(ReflectionContributionFactory.java:42)
	at org.eclipse.e4.ui.workbench.renderers.swt.ContributedPartRenderer.createWidget(ContributedPartRenderer.java:132)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createWidget(PartRenderingEngine.java:999)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:659)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:765)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$2.run(PartRenderingEngine.java:730)
	at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:45)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createGui(PartRenderingEngine.java:714)
	at org.eclipse.e4.ui.workbench.renderers.swt.SWTPartRenderer.processContents(SWTPartRenderer.java:71)
	at org.eclipse.e4.ui.workbench.renderers.swt.WBWRenderer.processContents(WBWRenderer.java:666)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:673)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.safeCreateGui(PartRenderingEngine.java:765)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$2.run(PartRenderingEngine.java:730)
	at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:45)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.createGui(PartRenderingEngine.java:714)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine$5.run(PartRenderingEngine.java:1083)
	at org.eclipse.core.databinding.observable.Realm.runWithDefault(Realm.java:338)
	at org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine.run(PartRenderingEngine.java:1046)
	at org.eclipse.e4.ui.internal.workbench.E4Workbench.createAndRunUI(E4Workbench.java:155)
	at org.eclipse.e4.ui.internal.workbench.swt.E4Application.start(E4Application.java:166)
	at org.eclipse.equinox.internal.app.EclipseAppHandle.run(EclipseAppHandle.java:203)
	at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.runApplication(EclipseAppLauncher.java:134)
	at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.start(EclipseAppLauncher.java:104)
	at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:401)
	at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:255)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.eclipse.equinox.launcher.Main.invokeFramework(Main.java:653)
	at org.eclipse.equinox.launcher.Main.basicRun(Main.java:590)
	at org.eclipse.equinox.launcher.Main.run(Main.java:1461)
	at org.eclipse.equinox.launcher.Main.main(Main.java:1434)
Caused by: org.osgi.framework.BundleException: Exception in org.eclipse.gef.mvc.examples.shapes.ShapesPlugin.start() of bundle org.eclipse.gef.mvc.examples.shapes.
	at org.eclipse.osgi.internal.framework.BundleContextImpl.startActivator(BundleContextImpl.java:835)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.start(BundleContextImpl.java:763)
	at org.eclipse.osgi.internal.framework.EquinoxBundle.startWorker0(EquinoxBundle.java:1011)
	at org.eclipse.osgi.internal.framework.EquinoxBundle$EquinoxModule.startWorker(EquinoxBundle.java:365)
	at org.eclipse.osgi.container.Module.doStart(Module.java:605)
	at org.eclipse.osgi.container.Module.start(Module.java:468)
	at org.eclipse.osgi.framework.util.SecureAction.start(SecureAction.java:506)
	at org.eclipse.osgi.internal.hooks.EclipseLazyStarter.postFindLocalClass(EclipseLazyStarter.java:117)
	... 42 more
Caused by: java.lang.NoClassDefFoundError: javafx/embed/swt/FXCanvas
	at org.eclipse.gef.mvc.fx.ui.MvcFxUiModule.bindFXCanvasFactory(MvcFxUiModule.java:58)
	at org.eclipse.gef.mvc.fx.ui.MvcFxUiModule.configure(MvcFxUiModule.java:142)
	at com.google.inject.AbstractModule.configure(AbstractModule.java:59)
	at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:223)
	at com.google.inject.spi.Elements.getElements(Elements.java:101)
	at com.google.inject.spi.Elements.getElements(Elements.java:92)
	at com.google.inject.util.Modules$RealOverriddenModuleBuilder$1.configure(Modules.java:172)
	at com.google.inject.AbstractModule.configure(AbstractModule.java:59)
	at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:223)
	at com.google.inject.spi.Elements.getElements(Elements.java:101)
	at com.google.inject.internal.InjectorShell$Builder.build(InjectorShell.java:133)
	at com.google.inject.internal.InternalInjectorCreator.build(InternalInjectorCreator.java:103)
	at com.google.inject.Guice.createInjector(Guice.java:95)
	at com.google.inject.Guice.createInjector(Guice.java:72)
	at com.google.inject.Guice.createInjector(Guice.java:62)
	at org.eclipse.gef.mvc.examples.shapes.ShapesPlugin.start(ShapesPlugin.java:16)
	at org.eclipse.osgi.internal.framework.BundleContextImpl$2.run(BundleContextImpl.java:814)
	at org.eclipse.osgi.internal.framework.BundleContextImpl$2.run(BundleContextImpl.java:1)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at org.eclipse.osgi.internal.framework.BundleContextImpl.startActivator(BundleContextImpl.java:806)
	... 49 more
Caused by: java.lang.ClassNotFoundException: javafx.embed.swt.FXCanvas cannot be found by org.eclipse.gef.mvc.fx.ui_5.1.1.202012080300
	at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:516)
	at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:171)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	... 69 more
</pre>
