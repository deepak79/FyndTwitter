package go.fynd.twitter.data

import go.fynd.twitter.data.local.db.DbHelper
import go.fynd.twitter.data.prefs.PrefsHelper

interface DataManager : DbHelper, PrefsHelper
