package trng.util;

import java.util.Observable;
import java.util.Observer;

class ObservableWeather extends Observable {
	private String weather;

	public ObservableWeather(String weather) {
		this.weather = weather;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
		setChanged();
		notifyObservers();
	}

}

class WeatherObserver1 implements Observer {

	private ObservableWeather observableWeather;

	@Override
	public void update(Observable observable, Object arg) {
		observableWeather = (ObservableWeather) observable;
		System.out.println("Weather1 Report Live. Its " + observableWeather.getWeather());
	}
}

class WeatherObserver2 implements Observer {

	private ObservableWeather observableWeather;

	@Override
	public void update(Observable observable, Object arg) {
		observableWeather = (ObservableWeather) observable;
		System.out.println("Weather2 Report Live. Its " + observableWeather.getWeather());
	}
}

public class ObserverExample {

	public static void main(String[] args) {
		ObservableWeather observable = new ObservableWeather(null);
		WeatherObserver1 observer1 = new WeatherObserver1();
		WeatherObserver2 observer2 = new WeatherObserver2();
		observable.addObserver(observer1);
		observable.addObserver(observer2);
		
		observable.setWeather("Bright and sunny...Let's play cricket!! ");
		observable.setWeather("Raining Heavily!..Let's have hot Pakodas!!");
	}
}
