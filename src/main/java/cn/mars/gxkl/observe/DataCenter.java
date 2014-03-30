package cn.mars.gxkl.observe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.mars.gxkl.utils.Pair;

public class DataCenter implements Observable {

	private int EXECUTOR_SIZE = 10;
	private Map<String, Observer> watchers = new HashMap<String, Observer>();
	private ExecutorService executors = Executors.newFixedThreadPool(EXECUTOR_SIZE);
//	private ConcurrentLinkedQueue<Pair<String,List<String>>> dataCache;
//	private ConcurrentLinkedQueue<Pair<String,List<String>>> emergCache;
	
	@Override
	public synchronized void register(Observer object, String job) {
		if(object == null) {
			throw new NullPointerException();
		}
		watchers.put(job, object);
	}

	@Override
	public synchronized void removeByJob(String job) {
		// TODO Auto-generated method stub
		watchers.remove(job);
	}

	public synchronized void removeAll() {
		watchers.clear();
	}
	
	
	@Override
	public void notifyByJob(String job, String msg) {
		Observer watcher = (Observer)watchers.get(job);
		watcher.exec(msg);
	}
		
	@Override
	public void notifyByObject(String object) {}
	
//	public synchronized Pair<String,List<Object>> getMessage() {
//		return dataCache.poll();
//	}
//	
//	public synchronized List<String> getEmergency() {
//		return emergCache.poll().getLast();
//	}
	
	public void update(final Pair<String, String> pair) {
		executors.execute(new Runnable() {
			@Override
			public void run() {
				notifyByJob(pair.getFirst(),pair.getLast());				
			}
		});
		
	}

}
