export function setMinDate(): string{
    let today = new Date();
    
    let hour = "";
    let day = "";
    let month = "";
    let year = "";

    let d = today.getDate();
    let m = today.getMonth() + 1;
    let y = today.getFullYear();
    let h = today.getHours();

    hour = h.toString();
    day = d.toString();
    month = m.toString();
    year = y.toString();


    if(h < 10)
      hour = '0' + hour;

    if(d < 10)
      day = '0' + d;
    
    if(m < 10)
      month = '0' + m;

    return year + '-' + month + '-' + day + 'T' + hour + ':00';
}