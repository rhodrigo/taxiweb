package br.com.taxi.util;

import org.apache.log4j.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Module;

import br.com.caelum.vraptor.ComponentRegistry;
import br.com.caelum.vraptor.ioc.guice.GuiceProvider;

public class CustomProvider extends GuiceProvider {

	private static final Logger LOG = Logger.getLogger(CustomProvider.class);

	@Override
	protected void registerCustomComponents(ComponentRegistry registry) {

	}

	@Override
	protected Module customModule() {

		final Module module = super.customModule();

		return new AbstractModule() {

			@Override
			public void configure() {

				module.configure(binder());

			}

		};
	}

}
