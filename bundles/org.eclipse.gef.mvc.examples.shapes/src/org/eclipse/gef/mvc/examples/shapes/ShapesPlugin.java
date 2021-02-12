package org.eclipse.gef.mvc.examples.shapes;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

public class ShapesPlugin implements BundleActivator {
	
	private static Injector injector;

	@Override
	public void start(BundleContext context) throws Exception {
		injector = Guice.createInjector(Modules.override(new ShapesExampleModule())
				.with(new ShapesExampleUiModule()));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

	public static Injector GetInjector() {
		return injector;
	}

}
