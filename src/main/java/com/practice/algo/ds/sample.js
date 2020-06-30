function solution(s) {
    const map = new Map();
    for (let c in Array.from(s)) {
        if (map.has(c) && !map.get(c)) {
            if (c >= 'a') {
                map.remove(c);
                map.put((c - 32), true);
            } else {
                map.put(c, true);
            }
        } else {
            if (c < 'a') {
                map.put((c + 32), false);
            } else {
                map.put( (c - 32), false);
            }
        }
    }

    let mapDesc = new Map([...map.entries()].sort((a,b) => a[0] < b[0]));

    let res = mapDes.entrySet().filter(m => m.getValue()).findFirst();

    if (res) {
        return res+"";
    }
    return "NO";
}

solution("WeTestCoDErs");