package com.zx.util.agent;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarCompare {

	private static Map<String, JarEntry> getEntryMap(JarFile jarFile) {
		Map<String, JarEntry> map = new HashMap();
		Enumeration<JarEntry> enumer = jarFile.entries();
		while (enumer.hasMoreElements()) {
			JarEntry entry = (JarEntry) enumer.nextElement();
			map.put(entry.getName(), entry);
		}
		return map;
	}

	public static List<Set<JarEntry>> getModifyContent(JarFile jarOld, JarFile jarNew) {
		Map<String, JarEntry> mapOld = getEntryMap(jarOld);
		Map<String, JarEntry> mapNew = getEntryMap(jarNew);

		List<Set<JarEntry>> list = new ArrayList();

		HashSet<JarEntry> addEntrys = new HashSet();
		HashSet<JarEntry> entrys = new HashSet();
		for (String strNew : mapNew.keySet()) {
			JarEntry entryNew = (JarEntry) mapNew.get(strNew);
			JarEntry entryOld = (JarEntry) mapOld.get(strNew);
			if (entryNew.getName().endsWith(".class")) {
				if (entryOld == null) {
					addEntrys.add(entryNew);
				} else if ((entryOld != null) && (entryNew.getCrc() != entryOld.getCrc())) {
					entrys.add(entryNew);
				}
			}
		}
		list.add(addEntrys);
		list.add(entrys);
		return list;
	}

}
